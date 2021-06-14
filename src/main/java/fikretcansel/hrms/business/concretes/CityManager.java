package fikretcansel.hrms.business.concretes;

import fikretcansel.hrms.business.abstracts.CityService;
import fikretcansel.hrms.core.utilities.results.concretes.*;
import fikretcansel.hrms.dataAccess.abstracts.CityDao;
import fikretcansel.hrms.entities.concretes.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    public CityManager(CityDao cityDao) {
        this.cityDao=cityDao;
    }


    public DataResult<List<City>> getAll() {

        return new SuccessDataResult<List<City>>(cityDao.findAll(),"Listelendi");
    }

    public Result add(City entity) {

        cityDao.save(entity);
        return new SuccessResult("Ekleme Başarılı");
    }

    public Result update(City entity) {

        return new SuccessResult("Güncelleme Başarılı,işlem yapılmadı dikkat");
    }

    public Result delete(City entity) {
        cityDao.delete(entity);
        return new SuccessResult("Silme Başarılı");
    }


}
