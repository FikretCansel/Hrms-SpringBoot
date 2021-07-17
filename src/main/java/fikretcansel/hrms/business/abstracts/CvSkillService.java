package fikretcansel.hrms.business.abstracts;

import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.CvEducation;
import fikretcansel.hrms.entities.concretes.CvSkill;

import java.util.List;

public interface CvSkillService {

    DataResult<List<CvSkill>> getAll();

    Result add(CvSkill entity);

    Result update(CvSkill entity);

    Result delete(CvSkill entity);

}
