package fikretcansel.hrms.business.concretes;

import fikretcansel.hrms.business.abstracts.EducationService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessResult;
import fikretcansel.hrms.dataAccess.abstracts.EducationDao;
import fikretcansel.hrms.entities.concretes.Education;
import org.springframework.stereotype.Service;

import java.util.List;

import static fikretcansel.hrms.business.constants.MessagesTr.deleteSuccess;
import static fikretcansel.hrms.business.constants.MessagesTr.saveSuccess;

@Service
public class EducationManager implements EducationService {
    private EducationDao educationDao;

    public EducationManager(EducationDao educationDao) {
        this.educationDao=educationDao;
    }


    @Override
    public DataResult<List<Education>> getAll() {
        return new SuccessDataResult<List<Education>>(educationDao.findAll());
    }

    @Override
    public Result add(Education entity) {


        educationDao.save(entity);
        return new SuccessResult(saveSuccess);
    }

    @Override
    public Result update(Education entity) {
        return null;
    }

    @Override
    public Result delete(Education entity) {
        educationDao.delete(entity);
        return new SuccessResult(deleteSuccess);
    }

}
