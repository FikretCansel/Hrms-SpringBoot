package fikretcansel.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","education"})
@Table(name = "educations")
@PrimaryKeyJoinColumn(name = "cvId",referencedColumnName = "cvId")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="schoolName",nullable = false)
    private String schoolName;
    @Column(name="programName",nullable = false)
    private String programName;
    @Column(name="startDate",nullable = false)
    private Date startDate;
    @Column(name="graduationDate")
    private Date graduationDate;

    @JsonIgnore
    @ManyToOne(targetEntity = Cv.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "cvId")
    private Cv cv;



}

