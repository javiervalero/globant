package com.globant.ticketmanager.domain;

public class Ticket {
	
	private Integer id;
	private String description;
	
	public Ticket(Integer id, String description){
		this.id = id;
		this.description = description;
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
}
