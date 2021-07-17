package fikretcansel.hrms.business.concretes;

import fikretcansel.hrms.business.abstracts.CvSkillService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessResult;
import fikretcansel.hrms.dataAccess.abstracts.CvSkillDao;
import fikretcansel.hrms.entities.concretes.CvEducation;
import fikretcansel.hrms.entities.concretes.CvSkill;
import org.springframework.stereotype.Service;

import java.util.List;

import static fikretcansel.hrms.business.constants.MessagesTr.*;

@Service
public class CvSkillManager implements CvSkillService {
    private CvSkillDao cvSkillDao;

    public CvSkillManager(CvSkillDao cvSkillDao){
        this.cvSkillDao=cvSkillDao;
    }


    @Override
    public DataResult<List<CvSkill>> getAll() {
        return new SuccessDataResult<List<CvSkill>>(cvSkillDao.findAll());
    }

    @Override
    public Result add(CvSkill entity) {
        cvSkillDao.save(entity);

        return new SuccessResult(saveSuccess);
    }

    @Override
    public Result update(CvSkill entity) {
        return  new SuccessResult(updateSuccess);
    }

    @Override
    public Result delete(CvSkill entity) {
        cvSkillDao.delete(entity);

        return new SuccessResult(deleteSuccess);
    }
}
