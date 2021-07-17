package fikretcansel.hrms.business.concretes;

import fikretcansel.hrms.business.abstracts.ExperienceService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessResult;
import fikretcansel.hrms.dataAccess.abstracts.CvExperienceDao;
import fikretcansel.hrms.entities.concretes.CvExperience;
import org.springframework.stereotype.Service;

import java.util.List;

import static fikretcansel.hrms.business.constants.MessagesTr.deleteSuccess;
import static fikretcansel.hrms.business.constants.MessagesTr.saveSuccess;

@Service
public class CvExperienceManager implements ExperienceService {
    private CvExperienceDao experienceDao;

    public CvExperienceManager(CvExperienceDao experienceDao) {
        this.experienceDao=experienceDao;
    }


    @Override
    public DataResult<List<CvExperience>> getAll() {
        return new SuccessDataResult<List<CvExperience>>(experienceDao.findAll());
    }

    @Override
    public Result add(CvExperience entity) {


        experienceDao.save(entity);
        return new SuccessResult(saveSuccess);
    }

    @Override
    public Result update(CvExperience entity) {
        return null;
    }

    @Override
    public Result delete(CvExperience entity) {
        experienceDao.delete(entity);
        return new SuccessResult(deleteSuccess);
    }
}
