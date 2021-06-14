package fikretcansel.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @Column(name="openPositionCount")
    private int openPositionCount;
    @Column(name="lastApplyDate")
    private Date lastApplyDate;
    @Column(name="creationDate")
    private Date creationDate;
    @Column(name="isActive",nullable = false)
    private Boolean isActive;



    @ManyToOne()
    @JoinColumn(name="cityId")
    private City city;

    @ManyToOne()
    @JoinColumn(name="employerId")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name="positionId")
    private JobPosition jobPosition;

    @JsonIgnore
    @OneToMany(mappedBy = "jobAdvertisement")
    private List<Candidate> candidates;

}

