package fikretcansel.hrms.business.concretes;

import fikretcansel.hrms.business.abstracts.CvLanguageService;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessResult;
import fikretcansel.hrms.dataAccess.abstracts.CvLanguageDao;
import fikretcansel.hrms.entities.concretes.CvLanguage;
import org.springframework.stereotype.Service;

import java.util.List;

import static fikretcansel.hrms.business.constants.MessagesTr.deleteSuccess;
import static fikretcansel.hrms.business.constants.MessagesTr.saveSuccess;

@Service
public class CvLanguageManager implements CvLanguageService {
    private CvLanguageDao cvLanguageDao;

    public CvLanguageManager (CvLanguageDao cvLanguageDao) {
        this.cvLanguageDao=cvLanguageDao;
    }


    @Override
    public SuccessDataResult<List<CvLanguage>> getAll() {
        return new SuccessDataResult<List<CvLanguage>>(cvLanguageDao.findAll());
    }

    @Override
    public Result add(CvLanguage entity) {

        cvLanguageDao.save(entity);
        return new SuccessResult(saveSuccess);
    }

    @Override
    public Result update(CvLanguage entity) {
        return null;
    }

    @Override
    public Result delete(CvLanguage entity) {
        cvLanguageDao.delete(entity);
        return new SuccessResult(deleteSuccess);
    }
}
