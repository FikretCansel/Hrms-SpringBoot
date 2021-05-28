package fikretcansel.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="JobPositions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPosition{
	@Id
	@GeneratedValue
	@Column(name="id")
	int id;
	@Column(name="name")
	String name;
	@Column(name="createDate")
	Date createDate;

}
