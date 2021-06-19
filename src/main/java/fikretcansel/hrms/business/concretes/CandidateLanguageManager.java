package fikretcansel.hrms.business.concretes;

import fikretcansel.hrms.business.abstracts.CandidateLanguageService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessResult;
import fikretcansel.hrms.dataAccess.abstracts.CandidateLanguageDao;
import fikretcansel.hrms.entities.concretes.CvLanguage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateLanguageManager implements CandidateLanguageService {

    private CandidateLanguageDao candidateLanguageDao;

    public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao) {
        this.candidateLanguageDao=candidateLanguageDao;
    }


    public DataResult<List<CvLanguage>> getAll() {

        return new SuccessDataResult<List<CvLanguage>>(candidateLanguageDao.findAll(),"Listelendi");
    }

    public Result add(CvLanguage entity) {

        candidateLanguageDao.save(entity);
        return new SuccessResult("Ekleme Başarılı");
    }

    public Result update(CvLanguage entity) {

        return new SuccessResult("Güncelleme Başarılı,işlem yapılmadı dikkat");
    }

    public Result delete(CvLanguage entity) {
        candidateLanguageDao.delete(entity);
        return new SuccessResult("Silme Başarılı");
    }

}
