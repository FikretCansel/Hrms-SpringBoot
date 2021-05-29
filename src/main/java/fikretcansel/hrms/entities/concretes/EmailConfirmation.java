package fikretcansel.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="EmailConfirmation")
@Data
@PrimaryKeyJoinColumn(name="userId")
@NoArgsConstructor
@AllArgsConstructor
public class EmailConfirmation{

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="confirmed")
	private Boolean confirmed;
	@Column(name="confirmationToken")
	private String confirmationToken;

}
