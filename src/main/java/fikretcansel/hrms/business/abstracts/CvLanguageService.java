package fikretcansel.hrms.business.abstracts;

import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessDataResult;
import fikretcansel.hrms.entities.concretes.CvLanguage;
import fikretcansel.hrms.entities.concretes.Language;

import java.util.List;

public interface CvLanguageService {

    SuccessDataResult<List<CvLanguage>> getAll();

    Result add(CvLanguage language);

    Result update(CvLanguage language);

    Result delete(CvLanguage language);
}
