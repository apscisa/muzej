package me.fit.rest;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.Muzej;
import me.fit.service.MuzejService;

@Path("/muzej")
public class MuzejRest {
	
	@Inject
	private MuzejService muzejService;
	
	
	@POST
	@Path("/addMuzej")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMuzej(Muzej m) {
		Muzej muzej = muzejService.createMuzej(m);
		
		return Response.ok().entity(muzej).build();
	}
	
	
	@GET
	@Path("/getAllMuzeji")
	@jakarta.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public Response getAllMuzeji() {
		List<Muzej> muzeji = muzejService.getAllMuzeji();
		
		return Response.ok().entity(muzeji).build();
	}
}

