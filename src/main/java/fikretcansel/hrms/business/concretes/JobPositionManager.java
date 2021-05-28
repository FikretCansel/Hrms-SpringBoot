package fikretcansel.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import fikretcansel.hrms.business.abstracts.JobPositionService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.ErrorResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessResult;
import fikretcansel.hrms.dataAccess.abstracts.JobPositionDao;
import fikretcansel.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	
private JobPositionDao jobPositionDao;
	
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao=jobPositionDao;
	}


	@Override
	public DataResult<List<JobPosition>> getAll() {

		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(),"Listelendi");
	}

	public Result add(JobPosition entity) {
		if(jobPositionDao.existsJobPositionByName(entity.getName())){
			return new ErrorResult("Bu iş pozisyonu zaten mevcut");
		}
		jobPositionDao.save(entity);
		return new SuccessResult("Ekleme Başarılı");
	}
	
	public Result update(JobPosition entity) {
		
		return new SuccessResult("Güncelleme Başarılı,işlem yapılmadı dikkat");
	}

	public Result delete(JobPosition entity) {
		jobPositionDao.delete(entity);
		return new SuccessResult("Silme Başarılı");
	}

	@Override
	public Result validation(JobPosition entity) {
		if(entity.getName().length()<1) {
			return new ErrorResult("isminizi giriniz");
		}
		return new SuccessResult();
	}
}
