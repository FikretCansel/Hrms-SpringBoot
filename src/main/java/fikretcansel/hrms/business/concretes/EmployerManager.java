package fikretcansel.hrms.business.concretes;



import java.util.List;

import fikretcansel.hrms.business.abstracts.EmailVerificationService;
import fikretcansel.hrms.entities.dto.LoginResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fikretcansel.hrms.business.abstracts.EmployerService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.ErrorDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.ErrorResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessResult;
import fikretcansel.hrms.dataAccess.abstracts.EmployerDao;
import fikretcansel.hrms.entities.concretes.Employer;
import fikretcansel.hrms.business.constants.MessagesTr;

import static fikretcansel.hrms.business.constants.MessagesTr.*;


@Service
public class EmployerManager implements EmployerService{

	
private EmployerDao employerDao;
private EmailVerificationService emailVerificationService;

	@Autowired
	public EmployerManager(EmployerDao employerDao,EmailVerificationService emailVerificationService) {
		this.employerDao=employerDao;
		this.emailVerificationService=  emailVerificationService;
	}
	
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(),getSuccess);

	}


	public Result update(Employer entity) {
		return new SuccessResult(updateSuccess);
	}

	public Result delete(Employer entity) {
		employerDao.delete(entity);
		return new SuccessResult(progressSuccess);
	}

	
	
	public DataResult register(Employer entity) {


        if(existEmail(entity.getEmail()).isSuccess()) {
            return new ErrorDataResult(null,userAlreadyRegistered);
        }
        
        var newUser=employerDao.save(entity);

        var sendMail=emailVerificationService.sendCodeToMail(newUser.getId());



        return new SuccessDataResult(newUser,progressSuccess);
    }

    
    public DataResult login(String email,String password) {

		var user=existEmail(email);


		Employer userData= (Employer) user.getData();

        if(!user.isSuccess()) {
            return new ErrorDataResult(null,userNotFound);
        }

        Employer employer=(Employer) existEmail(email).getData();

        if(!employer.getPassword().equals(password)){
			return new ErrorDataResult(null,wrongPassword);
		}


		LoginResultDto ResultData = new LoginResultDto(user,emailVerificationService.getIsVerifiedByUserId(userData.getId()).getData());


        return new SuccessDataResult(ResultData,loginSuccess);
    }
    
    public DataResult existEmail(String email) {
		Employer employer=employerDao.getByEmail(email);
		if(employer!=null){
			return new SuccessDataResult<Employer>(employer);
		}
        return new ErrorDataResult<Employer>(null,userNotFound);
    }

	@Override
	public DataResult<Employer> getById(int id) {

		return new SuccessDataResult<Employer>(employerDao.getById(id),getSuccess);
	}
}
