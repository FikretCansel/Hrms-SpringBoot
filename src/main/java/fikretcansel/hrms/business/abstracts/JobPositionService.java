package fikretcansel.hrms.business.abstracts;

import java.util.List;

import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.JobPosition;

public interface JobPositionService{

	DataResult<List<JobPosition>> getAll();
	
	Result add(JobPosition entity);
	
	Result update(JobPosition entity);
	
	Result delete(JobPosition entity);
	
	Result validation(JobPosition entity);
	
}
