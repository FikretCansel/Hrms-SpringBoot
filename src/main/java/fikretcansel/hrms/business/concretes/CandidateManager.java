package fikretcansel.hrms.business.concretes;

import fikretcansel.hrms.business.abstracts.CandidateService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessResult;
import fikretcansel.hrms.dataAccess.abstracts.CandidateDao;
import fikretcansel.hrms.dataAccess.abstracts.CityDao;
import fikretcansel.hrms.entities.concretes.Candidate;
import fikretcansel.hrms.entities.concretes.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;

    public CandidateManager(CandidateDao candidateDao) {
        this.candidateDao=candidateDao;
    }


    public DataResult<List<Candidate>> getAll() {

        return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(),"Listelendi");
    }

    public Result apply(Candidate entity) {

        candidateDao.save(entity);
        return new SuccessResult("Ekleme Başarılı");
    }

    public Result update(Candidate entity) {

        return new SuccessResult("Güncelleme Başarılı,işlem yapılmadı dikkat");
    }

    public Result delete(Candidate entity) {
        candidateDao.delete(entity);
        return new SuccessResult("Silme Başarılı");
    }

    @Override
    public DataResult<Boolean> getViewProfilePermission(int employerId,int jobSeekerId) {
        return new SuccessDataResult<Boolean>(candidateDao.existsAllByJobAdvertisementEmployerIdAndJobSeekerId(employerId,jobSeekerId));
    }
}
