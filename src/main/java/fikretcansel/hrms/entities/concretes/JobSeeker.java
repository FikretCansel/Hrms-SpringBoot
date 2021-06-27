package fikretcansel.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


@Entity
@Table(name="JobSeekers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="userId")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidates","cvs"})
public class JobSeeker extends User{
	@Length(max = 11,min = 11)
	@NotNull
	@NotBlank
	@Column(name="nationalIdentityNumber")
	String nationalIdentityNumber;
	@NotNull
	@NotBlank
	@Column(name="firstName")
	String firstName;
	@NotNull
	@NotBlank
	@Column(name="lastName")
	String lastName;
	@NotNull
	@Column(name="birthDate")
	Date birthDate;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<Candidate> candidates;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<Cv> cvs;
	
}
