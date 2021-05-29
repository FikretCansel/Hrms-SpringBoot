package fikretcansel.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

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
    @Column(name="jobPosition",nullable = false)
    private int jobPosition;
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

    @ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="cityId")
    private City city;

    public JobAdvertisement(int jobPosition,String jobDescription, int minSalary, int maxSalary, int openPositionCount,
                            Date lastApplyDate, Date createDate, boolean isActive) {
        super();
        this.jobPosition=jobPosition;
        this.description = jobDescription;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.openPositionCount = openPositionCount;
        this.lastApplyDate = lastApplyDate;
        this.creationDate = createDate;
        this.isActive = isActive;
    }
}

