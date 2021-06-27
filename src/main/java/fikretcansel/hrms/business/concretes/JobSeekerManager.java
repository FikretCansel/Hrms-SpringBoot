package fikretcansel.hrms.business.concretes;

import java.util.List;


import fikretcansel.hrms.business.abstracts.EmailVerificationService;
import fikretcansel.hrms.entities.dto.LoginResultDto;
import org.springframework.stereotype.Service;

import fikretcansel.hrms.business.abstracts.JobSeekerService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.ErrorDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.ErrorResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessResult;
import fikretcansel.hrms.dataAccess.abstracts.JobSeekerDao;
import fikretcansel.hrms.entities.concretes.JobSeeker;

import static fikretcansel.hrms.business.constants.MessagesTr.*;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private EmailVerificationService emailVerificationService;

    public JobSeekerManager(JobSeekerDao jobSeekerDao,EmailVerificationService emailVerificationService) {
        this.jobSeekerDao = jobSeekerDao;
        this.emailVerificationService=emailVerificationService;
    }


    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll(), "Kullancılar Listelendi");
    }


    @Override
    public Result update(JobSeeker entity) {

        return new SuccessResult(updateSuccess);
    }


    @Override
    public Result delete(JobSeeker entity) {
        jobSeekerDao.delete(entity);
        return new SuccessResult(deleteSuccess);
    }



    public DataResult register(JobSeeker entity) {

		if(existEmail(entity.getEmail()).isSuccess()) {
			return new ErrorDataResult(null,userAlreadyRegistered);
		}
		if(existNationalId(entity.getNationalIdentityNumber()).isSuccess()){
			return new ErrorDataResult(null,userAlreadyRegistered);
		}
		//if(!mernisAdapter.TcVertify(entity.getNationalIdentityNumber(),entity.getFirstName(),entity.getLastName(),entity.getBirthDate())){
          //  return new ErrorResult("Gerçek bilgi giriniz");
        //}

        var newUser=jobSeekerDao.save(entity);

        var sendMail=emailVerificationService.sendCodeToMail(newUser.getEmail(),newUser.getId());

		return new SuccessDataResult(newUser,saveSuccess);
    }


    public DataResult login(String email, String password) {

        var user=existEmail(email);

        JobSeeker userData= (JobSeeker) user.getData();

        if (!user.isSuccess()) {
            return new ErrorDataResult(null,userNotFound);
        }

        JobSeeker jobSeeker= (JobSeeker) existEmail(email).getData();

        if (!jobSeeker.getPassword().equals(password)) {
            return new ErrorDataResult(null,wrongPassword);
        }

        LoginResultDto ResultData = new LoginResultDto(user,emailVerificationService.getIsVerifiedByUserId(userData.getId()));


        return new SuccessDataResult(ResultData,loginSuccess);
    }

    public DataResult<JobSeeker> getById(int id){
        return new SuccessDataResult<JobSeeker>(jobSeekerDao.getById(id),getSuccess);
    }


    public DataResult existEmail(String email) {

		JobSeeker jobSeeker=jobSeekerDao.getByEmail(email);
		if(jobSeeker!=null){
			return new SuccessDataResult<JobSeeker>(jobSeeker);
		}
		return new ErrorDataResult<JobSeeker>(null,userNotFound);
    }

	public Result existNationalId(String nationalId) {

		boolean jobSeekerExist=jobSeekerDao.existsByNationalIdentityNumber(nationalId);
		if(jobSeekerExist){
			return new SuccessResult();
		}
		return new ErrorResult(userNotFound);
	}

}
