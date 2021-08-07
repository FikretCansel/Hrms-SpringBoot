package fikretcansel.hrms.business.concretes;



import java.util.List;

import fikretcansel.hrms.business.abstracts.EmailVerificationService;
import fikretcansel.hrms.core.utilities.results.concretes.*;
import fikretcansel.hrms.dataAccess.abstracts.EmployerUpdateDao;
import fikretcansel.hrms.entities.concretes.EmployerUpdate;
import fikretcansel.hrms.entities.dto.EmployerResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fikretcansel.hrms.business.abstracts.EmployerService;
import fikretcansel.hrms.dataAccess.abstracts.EmployerDao;
import fikretcansel.hrms.entities.concretes.Employer;

import static fikretcansel.hrms.business.constants.MessagesTr.*;


@Service
public class EmployerManager implements EmployerService{

	
private EmployerDao employerDao;
private EmailVerificationService emailVerificationService;
private EmployerUpdateDao employerUpdateDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao,EmailVerificationService emailVerificationService,EmployerUpdateDao employerUpdateDao) {
		this.employerDao=employerDao;
		this.emailVerificationService=  emailVerificationService;
		this.employerUpdateDao=employerUpdateDao;
	}
	
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(),getSuccess);

	}

	@Override
	public Result update(EmployerUpdate entity) {
		var employerUpdateDaoUser=employerUpdateDao.getByEmployerId(entity.getEmployerId());


		if(employerUpdateDaoUser!=null){
			entity.setId(employerUpdateDaoUser.getId());
		}

		employerUpdateDao.save(entity);

		return new SuccessResult(progressSuccess);
	}

	public Result delete(Employer entity) {
		employerDao.delete(entity);
		return new SuccessResult(progressSuccess);
	}

	
	@Override
	public DataResult<EmployerResultDto> register(Employer entity) {


        if(existEmail(entity.getEmail()).isSuccess()) {
            return new ErrorDataResult(null,userAlreadyRegistered);
        }
        
        var newUser=employerDao.save(entity);

        var sendMail=emailVerificationService.sendCodeToMail(newUser.getId());



		return new SuccessDataResult<EmployerResultDto>(new EmployerResultDto(entity,false),loginSuccess);
    }

	@Override
    public DataResult login(String email,String password) {

		DataResult<Employer> user=existEmail(email);


        if(!user.isSuccess()) {
            return new ErrorDataResult(null,userNotFound);
        }

        Employer employer=user.getData();

        if(!employer.getPassword().equals(password)){
			return new ErrorDataResult(null,wrongPassword);
		}

        return new SuccessDataResult<EmployerResultDto>(new EmployerResultDto(
        		employer,emailVerificationService.getIsVerifiedByUserId(employer.getId())
				.getData()),loginSuccess);
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
