package com.globant.ticketmanager.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.globant.ticketmanager.resource.ResourceBase;

@Provider
public class ResourceExceptionMapper implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception e) {
		return Response.status(404).
			      entity(ResourceBase.createResponse(0, e.getMessage()))
			      .build();
	}
	
}