package fikretcansel.hrms.business.concretes;

import fikretcansel.hrms.business.abstracts.CandidateService;
import fikretcansel.hrms.business.abstracts.EmailVerificationService;
import fikretcansel.hrms.core.utilities.results.concretes.*;
import fikretcansel.hrms.dataAccess.abstracts.CandidateDao;
import fikretcansel.hrms.dataAccess.abstracts.CityDao;
import fikretcansel.hrms.entities.concretes.Candidate;
import fikretcansel.hrms.entities.concretes.City;
import org.springframework.stereotype.Service;

import java.util.List;

import static fikretcansel.hrms.business.constants.MessagesTr.*;

@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;
    private EmailVerificationService emailVerificationService;

    public CandidateManager(CandidateDao candidateDao,EmailVerificationService emailVerificationService) {
        this.candidateDao=candidateDao;
        this.emailVerificationService=emailVerificationService;
    }


    public DataResult<List<Candidate>> getAll() {

        return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(),getSuccess);
    }

    public Result apply(Candidate entity) {

        int userId=entity.getJobSeeker().getId();

        var isEmailVerify=emailVerificationService.getIsVerifiedByUserId(userId);

        if(!isEmailVerify.getData()){
            return new ErrorResult(EmailVerifyIsNecessary);
        }

        var isApplied=candidateDao.existsByJobAdvertisementIdAndJobSeekerId(entity.getJobAdvertisement().getId(),userId);
        if(isApplied){
            return new ErrorResult(alreadyApplied);
        }

        candidateDao.save(entity);
        return new SuccessResult(saveSuccess);
    }
    public Result update(Candidate entity) {

        return new SuccessResult(updateSuccess);
    }
    public Result delete(Candidate entity) {
        candidateDao.delete(entity);
        return new SuccessResult(deleteSuccess);
    }

    @Override
    public DataResult<Boolean> getViewProfilePermission(int employerId,int jobSeekerId) {
        return new SuccessDataResult<Boolean>(candidateDao.existsAllByJobAdvertisementEmployerIdAndJobSeekerId(employerId,jobSeekerId));
    }

    @Override
    public DataResult<List<Candidate>> getAllByJobAdvertisementIdEmployerId(int jobAdvertisementId,int employerId) {
        List<Candidate> candidates=candidateDao.getAllByJobAdvertisementId(jobAdvertisementId);

        if(candidates.size()>=1){
            if(candidates.get(0).getJobAdvertisement().getEmployer().getId()!=employerId){
                return new ErrorDataResult<List<Candidate>>(null,notPermission);
            }
        }

        return new SuccessDataResult<List<Candidate>>(candidates,progressSuccess);
    }


}
