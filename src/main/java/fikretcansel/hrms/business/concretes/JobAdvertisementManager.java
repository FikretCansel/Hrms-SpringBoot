package fikretcansel.hrms.business.concretes;


import fikretcansel.hrms.business.abstracts.JobAdvertisementService;
import fikretcansel.hrms.core.utilities.results.concretes.*;
import fikretcansel.hrms.dataAccess.abstracts.JobAdvertisementDao;
import fikretcansel.hrms.entities.concretes.JobAdvertisement;
import fikretcansel.hrms.entities.dto.JobAdvertisementDto;
import org.springframework.stereotype.Service;

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

    public Result add(JobAdvertisement entity) {
        if(!validation(entity).isSuccess()){
            return new ErrorResult(validation(entity).getMessage());
        }
        jobAdvertisementDao.save(entity);

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
    public Result validation(JobAdvertisement entity) {

        if (entity.getMaxSalary() < 0 || entity.getMinSalary() < 0) {
            return new ErrorResult("ücret 0 dan küçük olamaz");
        } else if (entity.getDescription().length() < 3) {
            return new ErrorResult("açıklama 3 karakterden küçük olamaz");
        }

        return new SuccessResult();
    }

    @Override
    public DataResult<JobAdvertisement> getById(int id) {
        return new SuccessDataResult<>(jobAdvertisementDao.getById(id),"Listelendi");
    }
    @Override
    public DataResult<List<JobAdvertisement>> getByEmployerId(int id) {
        return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByEmployerId(id),"Listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisementDto>> getActiveAdvertisements() {

        return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisementDao.getActiveAdvertisements(),"Veriler Listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisementDto>> getActiveAdvertisementsByCreationDateList() {
        return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisementDao.getActiveAdvertisementsByCreationDateList(),"Listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisementDto>> getActiveAdvertisementsByEmployerId(int employerId) {
        return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisementDao.getActiveAdvertisementsByEmployerId(employerId),"Listelendi");
    }


}
