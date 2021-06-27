package fikretcansel.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="JobAdvertisements")
@AllArgsConstructor
@NoArgsConstructor
@Data


public class JobAdvertisement{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="description",nullable = false)
    private String description;
    @Column(name="minSalary")
    private int minSalary;
    @Column(name="maxSalary")
    private int maxSalary;
    @Column(name="openPositionCount",nullable = false)
    private int openPositionCount;
    @Column(name="lastApplyDate",nullable = false)
    private Date lastApplyDate;
    @Column(name="creationDate",nullable = false)
    private Date creationDate;
    @NotNull
    @Column(name="isActive",nullable = false)
    private Boolean isActive;



    @ManyToOne()
    @JoinColumn(name="cityId")
    private City city;

    @ManyToOne()
    @JoinColumn(name="employerId")
    private Employer employer;


    @ManyToOne()
    @JoinColumn(name="positionId",nullable = false)
    private JobPosition jobPosition;

    @JsonIgnore
    @OneToMany(mappedBy = "jobAdvertisement")
    private List<Candidate> candidates;

}

