package fikretcansel.hrms.entities.concretes;

public class EmailConfirmation {
	private int confirmationId;
	private String confirmationToken;
	
	public EmailConfirmation() {
		
	}
	
	public EmailConfirmation(int confirmationId, String confirmationToken) {
		super();
		this.confirmationId = confirmationId;
		this.confirmationToken = confirmationToken;
	}
	
	public int getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(int confirmationId) {
		this.confirmationId = confirmationId;
	}
	public String getConfirmationToken() {
		return confirmationToken;
	}
	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}
	
	
	
	
	
}
