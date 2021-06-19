package fikretcansel.hrms.business.abstracts;

import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.CvLanguage;

import java.util.List;

public interface CandidateLanguageService{

    DataResult<List<CvLanguage>> getAll();

    Result add(CvLanguage entity);

    Result update(CvLanguage entity);

    Result delete(CvLanguage entity);

}
