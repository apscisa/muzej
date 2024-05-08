package me.fit.rest.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import me.fit.IPLog;

@Path("/data")
@RegisterRestClient(configKey = "me.fit.rest.client.IpClient")
public interface IpClient {

	@GET
	@Path("/client-ip")
    IPLog getIpLog();
	
}
