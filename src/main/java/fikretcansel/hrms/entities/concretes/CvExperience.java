package fikretcansel.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
@Table(name = "cvExperiences")
public class CvExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @NotBlank
    @Column(name = "companyName")
    private String companyName;
    @NotNull
    @NotBlank
    @Column(name = "startDate")
    private Date startDate;
    @NotNull
    @NotBlank
    @Column(name = "departureDate")
    private Date departureDate;

    @JoinColumn(name = "cvId", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Cv.class, fetch = FetchType.EAGER)
    @JsonIgnore
    private Cv cv;

    @Column(name = "cvId")
    private int cvId;

}
