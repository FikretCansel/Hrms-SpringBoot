package fikretcansel.hrms.entities.concretes;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.util.List;

@Entity
@Table(name="Employers")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="userId")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class Employer extends User{
	@NotNull
	@NotBlank
	@Column(name="companyName")
	String companyName;
	@NotNull
	@NotBlank
	@Column(name="websiteLink")
	String websiteLink;
	@NotNull
	@NotBlank
	@Column(name="phone")
	String phone;

//	@Column(name="confirmationId")
//	int confirmationId;

	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;


}

