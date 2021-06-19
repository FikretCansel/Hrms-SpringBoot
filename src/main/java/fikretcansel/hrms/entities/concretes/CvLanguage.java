package fikretcansel.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
@PrimaryKeyJoinColumn(name = "cvId",referencedColumnName = "cvId")
@Table(name = "candidateLanguages")

public class CvLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="level")
    private short level;

    @Column(name="languageName")
    private String languageName;

    //@OneToMany(targetEntity=Language.class, mappedBy="candidateLanguage",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    //private List<Language> languages;

    @JoinColumn(name = "cvId", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Cv.class, fetch = FetchType.EAGER)
    @JsonIgnore
    private Cv cv;


    @Column(name = "cvId")
    private int cvId;

}
