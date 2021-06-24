package fikretcansel.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employerConfirmation")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employerConfirmation"})
public class EmployerConfirmation {
	@Id
	@Column(name="id")
	private int id;
	@Column(name = "confirmed")
	private boolean confirmed;
	@Column(name="confirmationDate")
	private Date confirmationData;


	
	
	
	
}
