package fikretcansel.hrms.entities.concretes;

public class userConfirmation {

	private int confirmationId;
	private int validatorUser;
	
	
	
	
	
	public userConfirmation(int confirmationId, int validatorUser) {
		super();
		this.confirmationId = confirmationId;
		this.validatorUser = validatorUser;
	}
	
	
	public int getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(int confirmationId) {
		this.confirmationId = confirmationId;
	}
	public int getValidatorUser() {
		return validatorUser;
	}
	public void setValidatorUser(int validatorUser) {
		this.validatorUser = validatorUser;
	}
	
	
	
	
}
