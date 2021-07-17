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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
@Table(name = "cvSkills")

public class CvSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @NotBlank
    @Column(name="name")
    private String name;


    @JoinColumn(name = "cvId", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Cv.class, fetch = FetchType.EAGER)
    @JsonIgnore
    private Cv cv;

    @Column(name = "cvId")
    private int cvId;

}
