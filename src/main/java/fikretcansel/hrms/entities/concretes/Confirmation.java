package fikretcansel.hrms.entities.concretes;

import java.sql.Date;

public class Confirmation {
	private int id;
	private boolean confirmed;
	private Date confirmationData;
	
	
	public Confirmation() {
		
	}
	
	
	
	public Confirmation(int id, boolean confirmed, Date confirmationData) {
		super();
		this.id = id;
		this.confirmed = confirmed;
		this.confirmationData = confirmationData;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isConfirmed() {
		return confirmed;
	}
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	public Date getConfirmationData() {
		return confirmationData;
	}
	public void setConfirmationData(Date confirmationData) {
		this.confirmationData = confirmationData;
	}
	
	
	
	
}
