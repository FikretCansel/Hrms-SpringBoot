package fikretcansel.hrms.business.concretes;

import fikretcansel.hrms.business.abstracts.*;
import fikretcansel.hrms.core.utilities.results.concretes.*;
import fikretcansel.hrms.dataAccess.abstracts.CvDao;
import fikretcansel.hrms.entities.concretes.Cv;
import fikretcansel.hrms.entities.concretes.CvLanguage;
import fikretcansel.hrms.entities.concretes.Education;
import fikretcansel.hrms.entities.concretes.Experience;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvManager implements CvService {

    private CvDao cvDao;
    private EducationService educationService;
    private ExperienceService experienceService;
    private CvLanguageService cvLanguageService;
    private CandidateService candidateService;

    public CvManager(CvDao cvDao, EducationService educationService,
                     ExperienceService experienceService, CvLanguageService cvLanguageService, CandidateService candidateService) {
        this.educationService=educationService;
        this.experienceService=experienceService;
        this.cvLanguageService=cvLanguageService;
        this.cvDao=cvDao;
        this.candidateService=candidateService;
    }


    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<List<Cv>>(cvDao.findAll());
    }

    @Override
    public Result add(Cv entity) {
        var cv = cvDao.save(entity);

        if(cv.getEducations()!=null){
            for (Education education :cv.getEducations()){
                education.setCv(cv);
                education.setId(cv.getId());
                educationService.add(education);
            }
       }
        if(cv.getExperiences()!=null){
            for (Experience experience :cv.getExperiences()){
                experience.setCv(cv);
                experience.setId(cv.getId());
                experienceService.add(experience);
            }
        }
        if(cv.getCvLanguages()!=null){
            for(CvLanguage cvLanguage:cv.getCvLanguages()){
                cvLanguage.setCv(cv);
                cvLanguage.setId(cv.getId());
                cvLanguageService.add(cvLanguage);
            }
        }

        return new SuccessResult("Ekleme Başarılı");
    }


    @Override
    public Result update(Cv entity) {
        return null;
    }

    @Override
    public Result delete(Cv entity) {
        cvDao.delete(entity);
        return new SuccessResult("Silme Başarılı");
    }

    @Override
    public DataResult<Cv> getById(int id) {




        return new SuccessDataResult<Cv>(cvDao.getAllById(id));
    }

    @Override
    public DataResult<Cv> getByJobSeekerIdForItSelf(int userId) {
        return new SuccessDataResult<Cv>(cvDao.getAllByJobSeekerId(userId));
    }

    @Override
    public DataResult<Cv> getByJobSeekerIdForEmployers(int jobSeekerId,int employerId) {
        if(!candidateService.getViewProfilePermission(employerId,jobSeekerId).getData()){
            return new ErrorDataResult<>(null,"Bu Profili görmeye izniniz yok");
        }


        return new SuccessDataResult<Cv>(cvDao.getAllByJobSeekerId(jobSeekerId));
    }





}
