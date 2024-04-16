package me.fit.rest;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.Korisnik;
import me.fit.service.KorisnikService;

@Path("/korisnik")
public class KorisnikRest {
	
	@Inject
	private KorisnikService korisnikService;
	
	
	@POST
	@Path("/addKorisnik")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addKorisnik(Korisnik k) {
		Korisnik korisnik = korisnikService.createKorisnik(k);
		
		return Response.ok().entity(korisnik).build();
	}
	
	
	@GET
	@Path("/getAllKorisnici")
	@jakarta.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public Response getAllKorisnici() {
		List<Korisnik> korisnici = korisnikService.getAllKorisnici();
		
		return Response.ok().entity(korisnici).build();
	}
}
