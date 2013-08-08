package com.globant.ticketmanager.resource;

import com.globant.ticketmanager.util.ResourceResponse;

public abstract class ResourceBase {

	public static ResourceResponse createResponse(int status, String message) {
		ResourceResponse r = new ResourceResponse();
		r.setStatus(status);
		r.setMessage(message);
		return r;
	}
	
	

}

