package fikretcansel.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="JobPositions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class JobPosition{
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@NotNull
	@NotBlank
	@Column(name="name")
	private String name;
	@NotNull
	@Column(name="createDate")
	private Date createDate;

	@JsonIgnore
	@OneToMany(mappedBy = "jobPosition")
	private List<JobAdvertisement> jobAdvertisements;

}
