package fikretcansel.hrms.business.concretes;

import fikretcansel.hrms.business.abstracts.SystemPersonnelService;
import fikretcansel.hrms.core.utilities.results.concretes.*;
import fikretcansel.hrms.dataAccess.abstracts.EmployerDao;
import fikretcansel.hrms.dataAccess.abstracts.EmployerUpdateDao;
import fikretcansel.hrms.dataAccess.abstracts.JobAdvertisementDao;
import fikretcansel.hrms.dataAccess.abstracts.SystemPersonnelDao;
import fikretcansel.hrms.entities.concretes.*;
import org.springframework.stereotype.Service;

import java.util.List;

import static fikretcansel.hrms.business.constants.MessagesTr.*;

@Service
public class SystemPersonnelManager implements SystemPersonnelService {
    private SystemPersonnelDao systemPersonnelDao;
    private EmployerDao employerDao;
    private JobAdvertisementDao jobAdvertisementDao;
    private EmployerUpdateDao employerUpdateDao;

    public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao, EmployerUpdateDao employerUpdateDao, EmployerDao employerDao, JobAdvertisementDao jobAdvertisementDao){
        this.systemPersonnelDao=systemPersonnelDao;
        this.employerDao=employerDao;
        this.jobAdvertisementDao=jobAdvertisementDao;
        this.employerUpdateDao=employerUpdateDao;
    }



    @Override
    public DataResult<SystemPersonnel> login(User systemPersonnel){
        var dataBaseUser=existEmail(systemPersonnel.getEmail());


        if(!dataBaseUser.isSuccess()) {
            return new ErrorDataResult(null,userNotFound);
        }


        if(!dataBaseUser.getData().getPassword().equals(systemPersonnel.getPassword())){
            return new ErrorDataResult(null,wrongPassword);
        }


        return new SuccessDataResult(dataBaseUser,loginSuccess);
    }
    @Override
    public Result verifyEmployer(int employerId){

        Employer newEmployer=employerDao.getById(employerId);

        if(newEmployer==null){
            return new ErrorResult(userNotFound);
        }

        newEmployer.setHrmsVerify(true);

        employerDao.save(newEmployer);

        return new SuccessResult(progressSuccess);
    }

    @Override
    public Result confirmEmployerUpdate(int employerId) {
        EmployerUpdate updateInfos= employerUpdateDao.getByEmployerId(employerId);

        if(updateInfos==null){
            return new ErrorResult(notFoundWillUpdateEmployer);
        }
        Employer currentData = convertConfirmEmployer(updateInfos,employerDao.findById(employerId).get());
        employerDao.save(currentData);
        employerUpdateDao.delete(updateInfos);
        return new SuccessResult(progressSuccess);
    }
    private Employer convertConfirmEmployer(EmployerUpdate employerUpdate,Employer employer){
        if(employerUpdate.getCompanyName()!=null){
            employer.setCompanyName(employerUpdate.getCompanyName());
        }
        if(employerUpdate.getEmail()!=null){
            employer.setEmail(employerUpdate.getEmail());
        }
        if(employerUpdate.getPhone()!=null){
            employer.setPhone(employerUpdate.getPhone());
        }
        if(employerUpdate.getWebsiteLink()!=null){
            employer.setWebsiteLink(employerUpdate.getWebsiteLink());
        }
        return employer;
    }

    @Override
    public Result verifyJobAdvertisementManager(int jobAdvertisementId){

        JobAdvertisement newJobAdvertisement=jobAdvertisementDao.getById(jobAdvertisementId);

        if(newJobAdvertisement==null){
            return new ErrorResult(userNotFound);
        }


        newJobAdvertisement.setHrmsVerify(true);

        jobAdvertisementDao.save(newJobAdvertisement);

        return new SuccessResult(progressSuccess);

    }
    @Override
    public DataResult<List<JobAdvertisement>> getAllPendingJobAdvertisements(){
        //return null;
        return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getAllByHrmsVerifyFalse());
    }
    @Override
    public DataResult<List<Employer>> getAllPendingEmployer(){
        //return null;
        return new SuccessDataResult<List<Employer>>(employerDao.getAllByHrmsVerifyFalse());
    }

    @Override
    public Result update(SystemPersonnel entity) {

        systemPersonnelDao.save(entity);

        return new SuccessResult(updateSuccess);
    }

    @Override
    public DataResult<SystemPersonnel> existEmail(String email) {
        SystemPersonnel systemPersonnel=systemPersonnelDao.getByEmail(email);
        if(systemPersonnel!=null){
            return new SuccessDataResult<SystemPersonnel>(systemPersonnel);
        }
        return new ErrorDataResult<SystemPersonnel>(null,userNotFound);
    }
}
