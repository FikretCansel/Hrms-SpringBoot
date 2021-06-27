package fikretcansel.hrms.business.concretes;


import fikretcansel.hrms.business.abstracts.JobAdvertisementService;
import fikretcansel.hrms.core.utilities.results.concretes.*;
import fikretcansel.hrms.dataAccess.abstracts.JobAdvertisementDao;
import fikretcansel.hrms.entities.concretes.JobAdvertisement;
import fikretcansel.hrms.entities.dto.JobAdvertisementDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;



import javax.validation.Valid;
import java.util.List;

import static fikretcansel.hrms.business.constants.MessagesTr.deleteSuccess;
import static fikretcansel.hrms.business.constants.MessagesTr.getSuccess;

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

    public Result add(@Valid @RequestBody JobAdvertisement entity) {

        jobAdvertisementDao.save(entity);

        return new SuccessResult("Kayıt Başarılı");
    }


    @Override
    public Result update(@Valid @RequestBody JobAdvertisement entity) {
        return null;
    }

    @Override
    public Result delete(JobAdvertisement entity) {
        jobAdvertisementDao.delete(entity);
        return new SuccessResult(deleteSuccess);
    }

    @Override
    public DataResult<JobAdvertisement> getById(int id) {
        return new SuccessDataResult<>(jobAdvertisementDao.getById(id),getSuccess);
    }
    @Override
    public DataResult<List<JobAdvertisement>> getByEmployerId(int id) {
        return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByEmployerId(id),getSuccess);
    }

    @Override
    public DataResult<List<JobAdvertisementDto>> getActiveAdvertisements() {

        return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisementDao.getActiveAdvertisements(),getSuccess);
    }

    @Override
    public DataResult<List<JobAdvertisementDto>> getActiveAdvertisementsByCreationDateList() {
        return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisementDao.getActiveAdvertisementsByCreationDateList(),getSuccess);
    }

    @Override
    public DataResult<List<JobAdvertisementDto>> getActiveAdvertisementsByEmployerId(int employerId) {
        return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisementDao.getActiveAdvertisementsByEmployerId(employerId),getSuccess);
    }


}
