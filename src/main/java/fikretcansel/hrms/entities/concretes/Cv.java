package fikretcansel.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "cvId",referencedColumnName = "cvId")
@Table(name = "cvs")
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

}
