package fikretcansel.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User{
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Email
	@NotBlank
	@NotNull
	@Column(name="email")
	private String email;
	@Length(min = 8)//uzunluk degişecek 8 olacak
	@NotNull
	@Column(name="password")
	private String password;
}
