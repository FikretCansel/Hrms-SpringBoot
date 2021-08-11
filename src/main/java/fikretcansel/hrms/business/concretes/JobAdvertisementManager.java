package fikretcansel.hrms.business.concretes;


import fikretcansel.hrms.business.abstracts.EmailVerificationService;
import fikretcansel.hrms.business.abstracts.JobAdvertisementService;
import fikretcansel.hrms.core.utilities.results.concretes.*;
import fikretcansel.hrms.dataAccess.abstracts.JobAdvertisementDao;
import fikretcansel.hrms.entities.concretes.JobAdvertisement;
import fikretcansel.hrms.entities.dto.JobAdvertisementBasicDataDto;
import fikretcansel.hrms.entities.dto.JobAdvertisementFilter;
import fikretcansel.hrms.entities.dto.JobAdvertisementHomeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;



import javax.validation.Valid;
import java.util.List;

import static fikretcansel.hrms.business.constants.MessagesTr.*;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;
    private EmailVerificationService emailVerificationService;

    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,EmailVerificationService emailVerificationService){
        this.jobAdvertisementDao=jobAdvertisementDao;
        this.emailVerificationService=emailVerificationService;
    }


    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(),"Veriler Listelendi");
    }

    public Result add(@Valid @RequestBody JobAdvertisement entity) {

        var isEmailVerify=emailVerificationService.getIsVerifiedByUserId(entity.getEmployer().getId());

        if(!isEmailVerify.getData()){
            return new ErrorResult(EmailVerifyIsNecessary);
        }

        jobAdvertisementDao.save(entity);

        return new SuccessResult(saveSuccess);
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
    public DataResult<List<JobAdvertisementBasicDataDto>> getActiveAdvertisements() {

        return new SuccessDataResult<List<JobAdvertisementBasicDataDto>>(jobAdvertisementDao.getActiveAdvertisements(),getSuccess);
    }

    @Override
    public DataResult<List<JobAdvertisementBasicDataDto>> getActiveAdvertisementsByCreationDateList() {
        return new SuccessDataResult<List<JobAdvertisementBasicDataDto>>(jobAdvertisementDao.getActiveAdvertisementsByCreationDateList(),getSuccess);
    }

    @Override
    public DataResult<List<JobAdvertisementBasicDataDto>> getActiveAdvertisementsByEmployerId(int employerId) {
        return new SuccessDataResult<List<JobAdvertisementBasicDataDto>>(jobAdvertisementDao.getActiveAdvertisementsByEmployerId(employerId),getSuccess);
    }
    @Override
    public DataResult<List<JobAdvertisementHomeDto>> getAllFilterAndPage(int pageNo, int pageSize, JobAdvertisementFilter advertFilter) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return new  SuccessDataResult<List<JobAdvertisementHomeDto>>(this.jobAdvertisementDao.
                getByFilterMain(advertFilter, pageable), getSuccess+"Sayfa:"+pageNo);
    }




}
