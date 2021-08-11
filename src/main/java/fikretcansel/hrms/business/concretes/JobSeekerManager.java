package fikretcansel.hrms.business.concretes;

import java.io.IOException;
import java.util.List;


import fikretcansel.hrms.business.abstracts.EmailVerificationService;
import fikretcansel.hrms.core.abstracts.PhotoService;
import fikretcansel.hrms.core.utilities.results.concretes.*;
import fikretcansel.hrms.entities.dto.EmployerResultDto;
import fikretcansel.hrms.entities.dto.JobSeekerResultDto;
import org.springframework.stereotype.Service;

import fikretcansel.hrms.business.abstracts.JobSeekerService;
import fikretcansel.hrms.dataAccess.abstracts.JobSeekerDao;
import fikretcansel.hrms.entities.concretes.JobSeeker;
import org.springframework.web.multipart.MultipartFile;

import static fikretcansel.hrms.business.constants.MessagesTr.*;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private EmailVerificationService emailVerificationService;
    private PhotoService photoService;

    public JobSeekerManager(JobSeekerDao jobSeekerDao,EmailVerificationService emailVerificationService,PhotoService photoService) {
        this.photoService=photoService;
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
    public Result uploadProfilePhoto(MultipartFile multipartFile,int userId) throws IOException {
        var uploadedPhotoUrl=photoService.uploadPhoto(multipartFile);

        var user=jobSeekerDao.getById(userId);

        user.setPhotoUrl(uploadedPhotoUrl.getData());

        jobSeekerDao.save(user);

        return new SuccessResult(uploadSuccess);
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

        var sendMail=emailVerificationService.sendCodeToMail(newUser.getId());

        return new SuccessDataResult<JobSeekerResultDto>(new JobSeekerResultDto(
                entity,false),loginSuccess);
    }


    public DataResult login(String email, String password) {

        DataResult<JobSeeker> user=existEmail(email);

        JobSeeker userData= (JobSeeker) user.getData();

        if (!user.isSuccess()) {
            return new ErrorDataResult(null,userNotFound);
        }

        JobSeeker jobSeeker= (JobSeeker) existEmail(email).getData();

        if (!jobSeeker.getPassword().equals(password)) {
            return new ErrorDataResult(null,wrongPassword);
        }

        return new SuccessDataResult<JobSeekerResultDto>(new JobSeekerResultDto(
                userData,emailVerificationService.getIsVerifiedByUserId(userData.getId())
                .getData()),loginSuccess);
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
