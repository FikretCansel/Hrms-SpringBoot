package fikretcansel.hrms.business.concretes;

import fikretcansel.hrms.business.abstracts.LanguageService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessResult;
import fikretcansel.hrms.dataAccess.abstracts.LanguageDao;
import fikretcansel.hrms.entities.concretes.Language;
import org.springframework.stereotype.Service;

import java.util.List;

import static fikretcansel.hrms.business.constants.MessagesTr.deleteSuccess;
import static fikretcansel.hrms.business.constants.MessagesTr.saveSuccess;

@Service
public class LanguageManager implements LanguageService {
    private LanguageDao languageDao;

    public LanguageManager(LanguageDao languageDao) {
        this.languageDao=languageDao;
    }


    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<List<Language>>(languageDao.findAll());
    }

    @Override
    public Result add(Language entity) {


        languageDao.save(entity);
        return new SuccessResult(saveSuccess);
    }

    @Override
    public Result update(Language entity) {
        return null;
    }

    @Override
    public Result delete(Language entity) {
        languageDao.delete(entity);
        return new SuccessResult(deleteSuccess);
    }
}
