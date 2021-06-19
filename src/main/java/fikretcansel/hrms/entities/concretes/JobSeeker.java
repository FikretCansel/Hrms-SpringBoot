package fikretcansel.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="JobSeekers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="userId")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidates","cvs","password","nationalIdentityNumber"})
public class JobSeeker extends User{

	@Column(name="nationalIdentityNumber")
	String nationalIdentityNumber;
	@Column(name="firstName")
	String firstName;
	@Column(name="lastName")
	String lastName;
	@Column(name="birthDate")
	Date birthDate;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<Candidate> candidates;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<Cv> cvs;
	
}
