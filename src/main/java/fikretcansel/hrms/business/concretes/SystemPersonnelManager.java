package fikretcansel.hrms.business.concretes;

import fikretcansel.hrms.business.abstracts.SystemPersonnelService;
import fikretcansel.hrms.core.utilities.results.concretes.*;
import fikretcansel.hrms.dataAccess.abstracts.EmployerDao;
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

    public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao,EmployerDao employerDao,JobAdvertisementDao jobAdvertisementDao){
        this.systemPersonnelDao=systemPersonnelDao;
        this.employerDao=employerDao;
        this.jobAdvertisementDao=jobAdvertisementDao;
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
    public DataResult<SystemPersonnel> existEmail(String email) {
        SystemPersonnel systemPersonnel=systemPersonnelDao.getByEmail(email);
        if(systemPersonnel!=null){
            return new SuccessDataResult<SystemPersonnel>(systemPersonnel);
        }
        return new ErrorDataResult<SystemPersonnel>(null,userNotFound);
    }
}
