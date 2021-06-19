package fikretcansel.hrms.business.abstracts;

import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.Education;
import fikretcansel.hrms.entities.concretes.Experience;

import java.util.List;

public interface ExperienceService {

    DataResult<List<Experience>> getAll();

    Result add(Experience entity);

    Result update(Experience entity);

    Result delete(Experience entity);

}
