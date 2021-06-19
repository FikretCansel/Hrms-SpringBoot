package fikretcansel.hrms.entities.concretes;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="Employers")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="userId")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements","password"})
public class Employer extends User{
	@Column(name="companyName")
	String companyName;
	@Column(name="websiteLink")
	String websiteLink;
	@Column(name="phone")
	String phone;
	@Column(name="confirmationId")
	int confirmationId;

	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;

}

