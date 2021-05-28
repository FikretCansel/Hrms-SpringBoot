package fikretcansel.hrms.dataAccess.abstracts;



import fikretcansel.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import fikretcansel.hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{
    JobSeeker getByEmail(String email);

    boolean existsByNationalIdentityNumber(String nationalIdentityNumber);


}
