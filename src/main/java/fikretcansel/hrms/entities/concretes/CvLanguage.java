package fikretcansel.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
@Table(name = "cvLanguages")

public class CvLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @NotBlank
    @Max(5)
    @Min(0)
    @Column(name="level")
    private short level;
    @NotNull
    @NotBlank
    @Column(name="languageName")
    private String languageName;


    @JoinColumn(name = "cvId", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Cv.class, fetch = FetchType.EAGER)
    @JsonIgnore
    private Cv cv;

    @Column(name = "cvId")
    private int cvId;

}
