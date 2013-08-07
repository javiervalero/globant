
package com.globant.ticketmanager.resources;

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

import com.globant.ticketmanager.domain.Ticket;
import com.globant.ticketmanager.util.DB;

/** Example resource class hosted at the URI path "/ticket"
 */
@Path("ticket")
public class TicketResource {
	
	/**
	 * Creates a ticket
	 * @param ticket
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Ticket ticket) {
		try {
			DB.putTicket(ticket);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(e);
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
	public void update(@PathParam("id") Integer id, Ticket ticket) {
		try {
			DB.updateTicket(id, ticket);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(e);
		}
	}
	
	/**
	 * Deletes a ticket
	 * @param id
	 */
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Integer id) {
		DB.deleteTicket(id);
	}
    
    /** 
     * Get Ticket by id
     * @return Ticket
     */
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Ticket get(@PathParam("id") int id) {
    	return DB.getTicket(id);
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
