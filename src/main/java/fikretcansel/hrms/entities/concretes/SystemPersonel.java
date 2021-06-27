package fikretcansel.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "userId")
@Table(name ="SystemPersonels")
@JsonIgnoreProperties({"password","email"})
public class SystemPersonel extends User{
    @NotNull
    @NotBlank
    @Column(name = "firstName")
    private String firstName;
    @NotNull
    @NotBlank
    @Column(name = "lastName")
    private String lastName;
}
