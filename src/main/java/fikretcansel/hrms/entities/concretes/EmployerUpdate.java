package fikretcansel.hrms.entities.concretes;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.NumberFormat;

import java.util.List;

@Entity
@Table(name="EmployerUpdate")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="userId")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class EmployerUpdate{
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

//    @UniqueElements
    @Column(name="employerId")
    private int employerId;


    @Email
    @NotBlank
    @NotNull
    @Column(name="email")
    private String email;
    @NotNull
    @NotBlank
    @Column(name="companyName")
    private String companyName;
    @NotNull
    @NotBlank
    @Column(name="websiteLink")
    private String websiteLink;
    @NotNull
    @NotBlank
    @Column(name="phone")
    private String phone;

}

