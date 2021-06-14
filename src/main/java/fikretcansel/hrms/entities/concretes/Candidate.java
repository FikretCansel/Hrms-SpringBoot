package fikretcansel.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidate"})
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne()
    @JoinColumn(name="jobSeekerId")
    private JobSeeker jobSeeker;


    @ManyToOne()
    @JoinColumn(name="jobAdvertisementId")
    private JobAdvertisement jobAdvertisement;

    
    //private JobAdvertisement jobAdvertisement;

    //private Cv cv;

}
