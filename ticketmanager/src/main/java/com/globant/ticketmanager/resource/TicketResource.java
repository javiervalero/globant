
package com.globant.ticketmanager.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.globant.ticketmanager.domain.Ticket;
import com.globant.ticketmanager.util.DB;
import com.sun.jersey.api.Responses;

/** Example resource class hosted at the URI path "/ticket"
 */
@Path("ticket")
public class TicketResource extends ResourceBase{
	
	/**
	 * Creates a ticket
	 * @param ticket
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Ticket ticket) {
		try {
			URI createdUri = new URI(ticket.getId().toString());
			DB.putTicket(ticket);
			return Response.created(createdUri)
				.entity(TicketResource.createResponse(0, "Ticket created successfully")).build();
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(e, 
				Response.status(Responses.CLIENT_ERROR)
				.entity(TicketResource.createResponse(0, e.getMessage())).build()
			);
		}
	}
	
	/**
	 * Updates a ticket
	 * @param ticket
	 * @throws Exception
	 */
	@POST
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Integer id, Ticket ticket) {
		try {
			DB.updateTicket(id, ticket);
			return Response.ok()
				.entity(TicketResource.createResponse(0, "Ticket id:" + id.toString() + " updated Successfully")).build();
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(e,
				Response.status(Responses.NOT_FOUND)
				.entity(TicketResource.createResponse(0, e.getMessage())).build()
			);
		}
	}
	
	/**
	 * Deletes a ticket
	 * @param id
	 * @throws Exception 
	 */
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") Integer id) {
		try {
			DB.deleteTicket(id);
			return Response.ok()
					.entity(TicketResource.createResponse(0, "Ticket id:" + id.toString() + " deleted Successfully")).build();
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(e,
				Response.status(Responses.NOT_FOUND)
				.entity(TicketResource.createResponse(0, e.getMessage())).build()
			);
		}
	}
    
    /** 
     * Get Ticket by id
     * @return Ticket
     */
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Ticket get(@PathParam("id") int id) {
    	try {
			return DB.getTicket(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(e,
				Response.status(Responses.NOT_FOUND)
				.entity(TicketResource.createResponse(0, e.getMessage())).build()
			);
		}
    }
    
    /**
     * Get All tickets
     * @return List
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> getAll() {
    	return DB.getTickets();
    }

}
