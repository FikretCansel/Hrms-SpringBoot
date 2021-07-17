package fikretcansel.hrms.business.concretes;

import fikretcansel.hrms.business.abstracts.*;
import fikretcansel.hrms.core.utilities.results.concretes.*;
import fikretcansel.hrms.dataAccess.abstracts.CvDao;
import fikretcansel.hrms.entities.concretes.*;
import org.springframework.stereotype.Service;

import java.util.List;

import static fikretcansel.hrms.business.constants.MessagesTr.*;

@Service
public class CvManager implements CvService {

    private CvDao cvDao;
    private EducationService educationService;
    private ExperienceService experienceService;
    private CvLanguageService cvLanguageService;
    private CandidateService candidateService;
    private CvSkillService cvSkillService;


    public CvManager(CvDao cvDao, EducationService educationService,
                     ExperienceService experienceService, CvLanguageService cvLanguageService, CandidateService candidateService,CvSkillService cvSkillService) {
        this.educationService=educationService;
        this.experienceService=experienceService;
        this.cvLanguageService=cvLanguageService;
        this.cvDao=cvDao;
        this.cvSkillService=cvSkillService;
        this.candidateService=candidateService;
    }


    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<List<Cv>>(cvDao.findAll());
    }

    @Override
    public Result add(Cv entity) {
        var cv = cvDao.save(entity);

        if(cv.getCvEducations()!=null){
            for (CvEducation education :cv.getCvEducations()){
                education.setCv(cv);
                education.setCvId(cv.getId());
                educationService.add(education);
            }
       }
        if(cv.getCvExperiences()!=null){
            for (CvExperience experience :cv.getCvExperiences()){
                experience.setCv(cv);
                experience.setCvId(cv.getId());
                experienceService.add(experience);
            }
        }
        if(cv.getCvLanguages()!=null){
            for(CvLanguage cvLanguage:cv.getCvLanguages()){
                cvLanguage.setCv(cv);
                cvLanguage.setCvId(cv.getId());
                cvLanguageService.add(cvLanguage);
            }
        }
        if(cv.getCvSkills()!=null){
            for(CvSkill cvSkill:cv.getCvSkills()){
                cvSkill.setCv(cv);
                cvSkill.setCvId(cv.getId());
                cvSkillService.add(cvSkill);
            }
        }


        return new SuccessResult(saveSuccess);
    }


    @Override
    public Result update(Cv entity) {

        var cv = cvDao.getAllByJobSeekerId(entity.getJobSeeker().getId());

        if(cv.getCvEducations()!=null){
            for (CvEducation education :cv.getCvEducations()){
                education.setCv(cv);
                education.setCvId(cv.getId());
                educationService.add(education);
            }
        }
        if(cv.getCvExperiences()!=null){
            for (CvExperience experience :cv.getCvExperiences()){
                experience.setCv(cv);
                experience.setCvId(cv.getId());
                experienceService.add(experience);
            }
        }
        if(cv.getCvLanguages()!=null){
            for(CvLanguage cvLanguage:cv.getCvLanguages()){
                cvLanguage.setCv(cv);
                cvLanguage.setCvId(cv.getId());
                cvLanguageService.add(cvLanguage);
            }
        }
        if(cv.getCvSkills()!=null){
            for(CvSkill cvSkill:cv.getCvSkills()){
                cvSkill.setCv(cv);
                cvSkill.setCvId(cv.getId());
                cvSkillService.add(cvSkill);
            }
        }
        return new SuccessResult(saveSuccess);
    }

    @Override
    public Result delete(Cv entity) {
        cvDao.delete(entity);
        return new SuccessResult(deleteSuccess);
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
            return new ErrorDataResult<>(null,NotPermission);
        }


        return new SuccessDataResult<Cv>(cvDao.getAllByJobSeekerId(jobSeekerId));
    }





}
