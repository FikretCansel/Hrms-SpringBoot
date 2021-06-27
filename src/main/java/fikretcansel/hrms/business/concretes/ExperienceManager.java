package fikretcansel.hrms.business.concretes;

import fikretcansel.hrms.business.abstracts.ExperienceService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessResult;
import fikretcansel.hrms.dataAccess.abstracts.ExperienceDao;
import fikretcansel.hrms.entities.concretes.Experience;
import org.springframework.stereotype.Service;

import java.util.List;

import static fikretcansel.hrms.business.constants.MessagesTr.deleteSuccess;
import static fikretcansel.hrms.business.constants.MessagesTr.saveSuccess;

@Service
public class ExperienceManager implements ExperienceService {
    private ExperienceDao experienceDao;

    public ExperienceManager(ExperienceDao experienceDao) {
        this.experienceDao=experienceDao;
    }


    @Override
    public DataResult<List<Experience>> getAll() {
        return new SuccessDataResult<List<Experience>>(experienceDao.findAll());
    }

    @Override
    public Result add(Experience entity) {


        experienceDao.save(entity);
        return new SuccessResult(saveSuccess);
    }

    @Override
    public Result update(Experience entity) {
        return null;
    }

    @Override
    public Result delete(Experience entity) {
        experienceDao.delete(entity);
        return new SuccessResult(deleteSuccess);
    }
}
