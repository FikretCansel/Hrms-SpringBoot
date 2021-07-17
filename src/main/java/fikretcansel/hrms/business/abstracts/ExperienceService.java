package fikretcansel.hrms.business.abstracts;

import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.CvExperience;

import java.util.List;

public interface ExperienceService {

    DataResult<List<CvExperience>> getAll();

    Result add(CvExperience entity);

    Result update(CvExperience entity);

    Result delete(CvExperience entity);

}
