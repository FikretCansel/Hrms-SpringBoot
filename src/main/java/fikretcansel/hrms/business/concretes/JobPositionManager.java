package fikretcansel.hrms.business.concretes;

import java.io.File;
import java.io.IOException;
import java.util.List;

import fikretcansel.hrms.core.concrete.CloudinaryManager;
import org.springframework.stereotype.Service;

import fikretcansel.hrms.business.abstracts.JobPositionService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.ErrorResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessResult;
import fikretcansel.hrms.dataAccess.abstracts.JobPositionDao;
import fikretcansel.hrms.entities.concretes.JobPosition;

import static fikretcansel.hrms.business.constants.MessagesTr.*;

@Service
public class JobPositionManager implements JobPositionService {
	
private JobPositionDao jobPositionDao;
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao=jobPositionDao;
	}


	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(),getSuccess);
	}

	public Result add(JobPosition entity) {
		if(jobPositionDao.existsJobPositionByName(entity.getName())){
			return new ErrorResult(jobPositionAlreadyExist);
		}
		jobPositionDao.save(entity);
		return new SuccessResult(saveSuccess);
	}
	
	public Result update(JobPosition entity) {
		
		return new SuccessResult(updateSuccess);
	}


	public Result delete(JobPosition entity) {
		jobPositionDao.delete(entity);
		return new SuccessResult(deleteSuccess);
	}


}
