package fikretcansel.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cvs")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})

public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="githubAddress")
    private String githubAddress;
    @Column(name="linkedinAddress")
    private String linkedinAddress;
    @Column(name="summary")
    private String summary;

    @ManyToOne()
    @JoinColumn(name="jobSeekerId")
    private JobSeeker jobSeeker;


    @OneToMany(mappedBy = "cv")
    private List<Education> educations;

    @OneToMany(mappedBy = "cv")
    private List<Experience> experiences;

    @OneToMany(mappedBy = "cv")
    private List<CvLanguage> cvLanguages;

}
