package com.globant.ticketmanager.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.globant.ticketmanager.resource.ResourceBase;

// TODO: remove comment if you want to use Exception Mapping
//@Provider
public class ResourceExceptionMapper implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception e) {
		return Response.status(404).
			      entity(ResourceBase.createResponse(0, e.getMessage()))
			      .build();
	}
	
}