package fikretcansel.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Employers")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="userId")
@Data

public class Employer extends User{
	@Column(name="companyName")
	String companyName;
	@Column(name="websiteLink")
	String websiteLink;
	@Column(name="phone")
	String phone;
	@Column(name="confirmationId")
	int confirmationId;

}

