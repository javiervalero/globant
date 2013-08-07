package com.globant.ticketmanager.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.globant.ticketmanager.domain.Ticket;

public class DB {
	
	static Map<Integer, Ticket> dbTicket = new HashMap<>();
	
	static {
		
		Ticket ticket1 = new Ticket(1, "Primer Ticket");
		dbTicket.put(1, ticket1);

		Ticket ticket2 = new Ticket(2, "Segundo Ticket");
		dbTicket.put(2, ticket2);

	}

	public static void putTicket(Ticket ticket) throws Exception {
		if (!dbTicket.containsKey(ticket.getId())){
			dbTicket.put(3, ticket);
		} else {
			throw new Exception("Ticket id:" + ticket.getId().toString() + " already exists");
		}
	}
	
	public static Ticket getTicket(Integer id) {
		return dbTicket.get(id);
	}
	
	public static void updateTicket(Integer id, Ticket ticket) throws Exception{
		if (dbTicket.containsKey(id)){
			dbTicket.put(id, ticket); 
		} else {
			// TODO: Handle exceptions ...
			throw new Exception("Ticket does not exist");
		}
	}

	public static List<Ticket> getTickets() {
		return new ArrayList<Ticket>(dbTicket.values());
	}
	
	public static void deleteTicket(Integer id) {
		dbTicket.remove(id);
	}
	
}

