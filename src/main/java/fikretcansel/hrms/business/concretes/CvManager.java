package fikretcansel.hrms.business.concretes;

import fikretcansel.hrms.business.abstracts.CvService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessResult;
import fikretcansel.hrms.dataAccess.abstracts.CvDao;
import fikretcansel.hrms.entities.concretes.Cv;
import fikretcansel.hrms.entities.concretes.Experience;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CvManager implements CvService {

    private CvDao cvDao;

    public CvManager(CvDao cvDao) {
        this.cvDao=cvDao;
    }


    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<List<Cv>>(cvDao.findAll());
    }

    @Override
    public Result add(Cv entity) {


        cvDao.save(entity);
        return new SuccessResult("Ekleme Başarılı");
    }

    @Override
    public Result update(Cv entity) {
        return null;
    }

    @Override
    public Result delete(Cv entity) {
        cvDao.delete(entity);
        return new SuccessResult("Silme Başarılı");
    }

    @Override
    public DataResult<Cv> getAllById(int id) {
        return new SuccessDataResult<Cv>(cvDao.getAllById(id));
    }
    @Override
    public DataResult<List<Cv>> getAllByJobSeekerId(int jobSeekerId) {
        return new SuccessDataResult<List<Cv>>(cvDao.getAllByJobSeekerId(jobSeekerId));
    }

}
