package fikretcansel.hrms.business.abstracts;


import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import org.springframework.stereotype.Service;

import fikretcansel.hrms.entities.concretes.JobSeeker;

@Service
public interface JobSeekerService extends UserBase<JobSeeker> {

    DataResult<JobSeeker> getById(int id);
	
}
