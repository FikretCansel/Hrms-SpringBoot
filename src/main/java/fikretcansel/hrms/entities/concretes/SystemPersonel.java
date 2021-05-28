package fikretcansel.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "userId")
@Table(name ="SystemPersonels")
public class SystemPersonel extends User{
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
}
