package com.globant.ticketmanager.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.globant.ticketmanager.domain.Ticket;

public class DB {
	
	static Map<Integer, Ticket> dbTicket = new HashMap<>();
	
	static {
		
		Ticket ticket = new Ticket();
		ticket.setId(1);
		ticket.setDescription("Ticket 1");
		dbTicket.put(1, ticket);

		ticket = new Ticket();
		ticket.setId(2);
		ticket.setDescription("Ticket 2");
		dbTicket.put(2, ticket);

	}

	public static void putTicket(Ticket ticket) throws Exception {
		if (!dbTicket.containsKey(ticket.getId())){
			dbTicket.put(ticket.getId(), ticket);
		} else {
			throw new Exception("Ticket id:" + ticket.getId().toString() + " already exists");
		}
	}
	
	public static Ticket getTicket(Integer id) throws Exception {
		if (dbTicket.containsKey(id)){
			return dbTicket.get(id);
		} else {
			throw new Exception("Ticket does not exist");
		}
	}
	
	public static void updateTicket(Integer id, Ticket ticket) throws Exception{
		if (dbTicket.containsKey(id)){
			dbTicket.put(id, ticket);
		} else {
			throw new Exception("Ticket does not exist");
		}
	}

	public static List<Ticket> getTickets() {
		return new ArrayList<Ticket>(dbTicket.values());
	}
	
	public static void deleteTicket(Integer id) throws Exception {
		if (dbTicket.containsKey(id)){
			dbTicket.remove(id);
		} else {
			throw new Exception("Ticket does not exist");
		}
	}
	
}

