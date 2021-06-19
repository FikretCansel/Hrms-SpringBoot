package fikretcansel.hrms.business.concretes;

import java.util.List;


import org.springframework.stereotype.Service;

import fikretcansel.hrms.business.abstracts.JobSeekerService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.ErrorDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.ErrorResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessResult;
import fikretcansel.hrms.dataAccess.abstracts.JobSeekerDao;
import fikretcansel.hrms.entities.concretes.Employer;
import fikretcansel.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;

    public JobSeekerManager(JobSeekerDao jobSeekerDao) {
        this.jobSeekerDao = jobSeekerDao;
    }


    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll(), "Kullancılar Listelendi");
    }

    private Result add(JobSeeker entity) {
        jobSeekerDao.save(entity);
        return new SuccessResult("Ekleme Başarılı");
    }


    @Override
    public Result update(JobSeeker entity) {

        return new SuccessResult("Güncelleme Başarılı");
    }


    @Override
    public Result delete(JobSeeker entity) {
        jobSeekerDao.delete(entity);
        return new SuccessResult("Silme Başarılı");
    }

    public Result validation(JobSeeker entity) {
        if (entity.getNationalIdentityNumber().length() != 11) {
            return new ErrorResult("kimlik numarası 11 karakter olmalıdır");
        } else if (entity.getPassword().length() < 3) {
            return new ErrorResult("şifre 3 karakterden çok olmalıdır");
        }
        else if(entity.getEmail().length()<3){
            return new ErrorResult("geçerli bir email giriniz!");
        }

        else if(entity.getFirstName().length()<3){
            return new ErrorResult("geçerli bir ad giriniz!");
        }
        else if(entity.getLastName().length()<3){
            return new ErrorResult("geçerli bir soyad giriniz!");
        }
        else if(entity.getBirthDate()==null){
            return new ErrorResult("geçerli bir dogum tarihi giriniz!");
        }

        return new SuccessResult();
    }


    public DataResult register(JobSeeker entity,String repeatPassword) {
		if(!validation(entity).isSuccess()) {
			return new ErrorDataResult(validation(entity).getMessage());
		}

		if(existEmail(entity.getEmail()).isSuccess()) {
			return new ErrorDataResult("Kullanıcı zaten kayıtlı");
		}
		if(existNatinalId(entity.getNationalIdentityNumber()).isSuccess()){
			return new ErrorDataResult("Bu kimlikli kişi kayıtlı");
		}
		//if(!mernisAdapter.TcVertify(entity.getNationalIdentityNumber(),entity.getFirstName(),entity.getLastName(),entity.getBirthDate())){
          //  return new ErrorResult("Gerçek bilgi giriniz");
        //}
        /*
		if(repeatPassword.equals(entity.getPassword())){
            return new ErrorResult("Şifreler aynı degil");
        }
        */
		add(entity);

		var user =existEmail(entity.getEmail()).getData();

		return new SuccessDataResult(user,"Kayıt Başarılı");
    }


    public DataResult login(String email, String password) {

        var user=existEmail(email);

        if (!user.isSuccess()) {
            return new ErrorDataResult("Kullanıcı Bulunamadı");
        }

        JobSeeker jobSeeker= (JobSeeker) existEmail(email).getData();

        if (!jobSeeker.getPassword().equals(password)) {
            return new ErrorDataResult("Şifre Yanlış");
        }


        return new SuccessDataResult(user.getData(),"Giriş Başarılı");
    }

    public DataResult existEmail(String email) {

		JobSeeker jobSeeker=jobSeekerDao.getByEmail(email);
		if(jobSeeker!=null){
			return new SuccessDataResult<JobSeeker>(jobSeeker);
		}
		return new ErrorDataResult<JobSeeker>(null,"Kullanıcı yok");
    }

	public Result existNatinalId(String nationalId) {

		boolean jobSeekerExist=jobSeekerDao.existsByNationalIdentityNumber(nationalId);
		if(jobSeekerExist){
			return new SuccessResult();
		}
		return new ErrorResult("Kullanıcı yok");
	}

}
