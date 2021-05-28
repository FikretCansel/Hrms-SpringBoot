package fikretcansel.hrms.business.concretes;



import java.util.List;

import fikretcansel.hrms.core.Verifies.Adapter;
import fikretcansel.hrms.core.Verifies.MernisAdaptor;
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


@Service
public class EmployerManager implements EmployerService{

	
private EmployerDao employerDao;


	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao=employerDao;
	}
	
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"Kullancılar Listelendi");
	}


	public Result update(Employer entity) {
		return new SuccessResult("Güncelleme Başarılı");
	}

	public Result delete(Employer entity) {
		employerDao.delete(entity);
		return new SuccessResult("Silme Başarılı");
	}

	public Result validation(Employer entity) {
		if(entity.getPhone().length()!=11) {
			return new ErrorResult("telefon numarası 11 karakter olmalıdır");
		}
		else if(entity.getPassword().length()<3) {
			return new ErrorResult("şifre 3 karakterden çok olmalıdır");
		}
		else if(entity.getCompanyName().length()<3){
			return new ErrorResult("Şirket ismi 3 karakterden çok olamaz");
		}
		else if(entity.getEmail().length()<3){
			return new ErrorResult("geçerli bir email giriniz!");
		}
		else if(entity.getWebsiteLink().length()<3){
			return new ErrorResult("geçerli bir website giriniz!");
		}
		return new SuccessResult();
	}
	
	private Result add(Employer entity) {
		employerDao.save(entity);
		return new SuccessResult();
	}
	
	
	public Result register(Employer entity,String repeatPassword) {
        if(!validation(entity).isSuccess()) {
            return new ErrorResult(validation(entity).getMessage());
        }
        if(existEmail(entity.getEmail()).isSuccess()) {
            return new ErrorResult("Kullanıcı zaten kayıtlı");
        }
        
        add(entity);
        
        return new SuccessResult("Kayıt Başarılı");
    }

    
    public Result login(String email,String password) {
        if(!existEmail(email).isSuccess()) {
            return new ErrorResult("Kullanıcı Bulunamadı");
        }

        Employer employer=(Employer) existEmail(email).getData();

        if(!employer.getPassword().equals(password)){
			return new ErrorResult("Şifre Yanlış");
		}


        return new SuccessResult("Giriş Başarılı");
    }
    
    public DataResult existEmail(String email) {
		Employer employer=employerDao.getByEmail(email);
		if(employer!=null){
			return new SuccessDataResult<Employer>(employer);
		}
        return new ErrorDataResult<Employer>(null,"Kullanıcı yok");
    }
}
