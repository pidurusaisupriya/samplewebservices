package com.app1.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("/hello")
public class HelloService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static Response sayHelloJson(){
		JSONObject response = new JSONObject();
		response.put("Message", "Hello friend");
		response.put("Date", System.currentTimeMillis());
		return Response.status(200).entity(response.toString()).build();
	}

}
