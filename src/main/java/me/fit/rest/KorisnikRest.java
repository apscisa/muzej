package me.fit.rest;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.IPLog;
import me.fit.Korisnik;
import me.fit.rest.client.IpClient;
import me.fit.service.KorisnikService;

@Path("/korisnik")
public class KorisnikRest {
	
	@RestClient
	@Inject
	IpClient ipclient;
	
	private KorisnikService korisnikService;
	
	
	@POST
	@Path("/addKorisnik")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addKorisnik(Korisnik k) {
		IPLog iplog = ipclient.getIpLog(); 
		Korisnik korisnik = korisnikService.createKorisnik(k, iplog);
		
		return Response.ok().entity(korisnik).build();
	}
	
	@GET
	@Path("/getAllKorisnike")
	@jakarta.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public Response getAllKorisnici() {
		List<Korisnik> korisnici = korisnikService.getAllKorisnike();
		
		return Response.ok().entity(korisnici).build();
	}
}
