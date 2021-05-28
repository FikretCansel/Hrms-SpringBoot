package fikretcansel.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="JobSeekers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="userId")

public class JobSeeker extends User{

	@Column(name="confirmationId")
	int confirmationId;
	@Column(name="nationalIdentityNumber")
	String nationalIdentityNumber;
	@Column(name="firstName")
	String firstName;
	@Column(name="lastName")
	String lastName;
	@Column(name="birthDate")
	Date birthDate;

	
	
}
