package fikretcansel.hrms.business.abstracts;

import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.CvEducation;

import java.util.List;

public interface EducationService {
    DataResult<List<CvEducation>> getAll();

    Result add(CvEducation entity);

    Result update(CvEducation entity);

    Result delete(CvEducation entity);

    Result deleteAllByCvId(int cvId);
}
