package fikretcansel.hrms.business.concretes;


import fikretcansel.hrms.business.abstracts.JobAdvertisementService;
import fikretcansel.hrms.core.utilities.results.concretes.*;
import fikretcansel.hrms.dataAccess.abstracts.JobAdvertisementDao;
import fikretcansel.hrms.entities.concretes.City;
import fikretcansel.hrms.entities.concretes.JobAdvertisement;
import fikretcansel.hrms.entities.concretes.JobPosition;
import fikretcansel.hrms.entities.dto.JobAdvertisementDto;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;

    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao){
        this.jobAdvertisementDao=jobAdvertisementDao;
    }


    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(),"Veriler Listelendi");
    }

    @Override
    public Result add(JobAdvertisementDto entity) {
        if(!validation(entity).isSuccess()){
            return new ErrorResult(validation(entity).getMessage());
        }


        JobAdvertisement jobAdvertisement=new JobAdvertisement(
                entity.getJobPosition(),entity.getDescription(),
                entity.getMinSalary(),
                entity.getMaxSalary(),entity.getOpenPositionCount(),
                new Date(),new Date(),
                true);


        jobAdvertisementDao.save(jobAdvertisement);

        return new SuccessResult("Kayıt Başarılı");
    }

    @Override
    public Result update(JobAdvertisement entity) {
        return null;
    }

    @Override
    public Result delete(JobAdvertisement entity) {
        jobAdvertisementDao.delete(entity);
        return new SuccessResult("Başarıyla Silindi");
    }

    @Override
    public Result validation(JobAdvertisementDto entity) {

        if (entity.getMaxSalary() < 0 || entity.getMinSalary() < 0) {
            return new ErrorResult("ücret 0 dan küçük olamaz");
        } else if (entity.getDescription().length() < 3) {
            return new ErrorResult("açıklama 3 karakterden küçük olamaz");
        }

        return new SuccessResult();
    }


}
