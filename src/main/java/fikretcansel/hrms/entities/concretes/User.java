package fikretcansel.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name="Users")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User{
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
}
