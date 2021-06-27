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
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
@PrimaryKeyJoinColumn(name = "cvId",referencedColumnName = "cvId")
@Table(name = "experiences")
public class Experience {
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

    @NotNull
    @NotBlank
    @ManyToOne(targetEntity = Cv.class, fetch = FetchType.EAGER)
    @JoinColumn(name="cvId")
    @JsonIgnore
    private Cv cv;

}
