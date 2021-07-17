package fikretcansel.hrms.entities.dto;

import com.sun.istack.NotNull;
import fikretcansel.hrms.entities.concretes.Employer;
import fikretcansel.hrms.entities.concretes.JobSeeker;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class JobSeekerResultDto{
    private int Id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String photoUrl;
    private String email;

    private boolean emailVerified;

    public JobSeekerResultDto(JobSeeker jobSeeker, boolean emailVerified){
        this.setId(jobSeeker.getId());
        this.setFirstName(jobSeeker.getFirstName());
        this.setLastName(jobSeeker.getLastName());
        this.setBirthDate(jobSeeker.getBirthDate());
        this.setEmailVerified(emailVerified);
        this.setEmail(jobSeeker.getEmail());
    }

}
