
package com.globant.ticketmanager.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.globant.ticketmanager.domain.Ticket;

/** Example resource class hosted at the URI path "/ticket"
 */
@Path("/ticket")
public class TicketResource {
    
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET 
    @Produces(MediaType.APPLICATION_JSON) //"text/plain"
    @Path("{id}")
    public Ticket get(@PathParam("id") int id) {
        return new Ticket(id, "test");
    }
    
    @GET 
    @Produces(MediaType.APPLICATION_JSON) //"text/plain"
    public List<Ticket> getAll() {
    	List<Ticket> aux = new ArrayList<Ticket>();
    	aux.add(new Ticket(1, "qwerqwer"));
    	aux.add(new Ticket(2, "asdfsdf"));
    	return aux;
    }
    
}
