package fikretcansel.hrms.business.concretes;

import java.util.List;

import fikretcansel.hrms.core.Verifies.Adapter;
import fikretcansel.hrms.core.Verifies.MernisAdaptor;
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
    private Adapter mernisAdapter;

    public JobSeekerManager(JobSeekerDao jobSeekerDao) {
        this.jobSeekerDao = jobSeekerDao;
        this.mernisAdapter=new MernisAdaptor();
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
            return new ErrorResult("geçerli bir website giriniz!");
        }
        else if(entity.getLastName().length()<3){
            return new ErrorResult("geçerli bir website giriniz!");
        }
        else if(entity.getBirthDate()==null){
            return new ErrorResult("geçerli bir website giriniz!");
        }

        return new SuccessResult();
    }


    public Result register(JobSeeker entity,String repeatPassword) throws Exception {
		if(!validation(entity).isSuccess()) {
			return new ErrorResult(validation(entity).getMessage());
		}

		if(existEmail(entity.getEmail()).isSuccess()) {
			return new ErrorResult("Kullanıcı zaten kayıtlı");
		}
		if(existNatinalId(entity.getNationalIdentityNumber()).isSuccess()){
			return new ErrorResult("Bu kimlikli kişi kayıtlı");
		}
		if(!mernisAdapter.TcVertify(entity.getNationalIdentityNumber(),entity.getFirstName(),entity.getLastName(),entity.getBirthDate())){
            return new ErrorResult("Gerçek bilgi giriniz");
        }
        /*
		if(repeatPassword.equals(entity.getPassword())){
            return new ErrorResult("Şifreler aynı degil");
        }
        */



		add(entity);

		return new SuccessResult("Kayıt Başarılı");
    }


    public Result login(String email, String password) {

        if (!existEmail(email).isSuccess()) {
            return new ErrorResult("Kullanıcı Bulunamadı");
        }

        JobSeeker employer = (JobSeeker) existEmail(email).getData();

        if (!employer.getPassword().equals(password)) {
            return new ErrorResult("Şifre Yanlış");
        }


        return new SuccessResult("Giriş Başarılı");
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
