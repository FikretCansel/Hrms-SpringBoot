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
    private JobSeekerService jobSeekerService;


    public CvManager(CvDao cvDao,JobSeekerService jobSeekerService, EducationService educationService,
                     ExperienceService experienceService, CvLanguageService cvLanguageService, CandidateService candidateService,CvSkillService cvSkillService) {
        this.educationService=educationService;
        this.experienceService=experienceService;
        this.cvLanguageService=cvLanguageService;
        this.cvDao=cvDao;
        this.cvSkillService=cvSkillService;
        this.candidateService=candidateService;
        this.jobSeekerService=jobSeekerService;
    }


    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<List<Cv>>(cvDao.findAll());
    }

    @Override
    public Result addAndEdit(Cv entity) {

        Cv cv = cvDao.getAllByJobSeekerId(entity.getJobSeeker().getId());

        if(cv==null){
            cv = cvDao.save(entity);
        }else{
            cv.setSummary(entity.getSummary());
            cv.setGithubAddress(entity.getGithubAddress());
            cv.setLinkedinAddress(entity.getLinkedinAddress());
            cvDao.save(cv);
        }
        if(entity.getCvEducations()!=null){
            educationService.deleteAllByCvId(cv.getId());
            for (CvEducation education :entity.getCvEducations()){
                education.setCv(cv);
                education.setCvId(cv.getId());
                educationService.add(education);
            }
        }
        if(entity.getCvExperiences()!=null){
            experienceService.deleteAllByCvId(cv.getId());
            for (CvExperience experience :entity.getCvExperiences()){

                experience.setCv(cv);
                experience.setCvId(cv.getId());
                experienceService.add(experience);
            }
        }
        if(entity.getCvLanguages()!=null){
            cvLanguageService.deleteAllByCvId(cv.getId());
            for(CvLanguage cvLanguage:entity.getCvLanguages()){

                cvLanguage.setCv(cv);
                cvLanguage.setCvId(cv.getId());
                cvLanguageService.add(cvLanguage);
            }
        }
        if(entity.getCvSkills()!=null){
            cvSkillService.deleteAllByCvId(cv.getId());
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
            return new ErrorDataResult<>(null, notPermission);
        }

        Cv cvResult=cvDao.getAllByJobSeekerId(jobSeekerId);

        if(cvResult==null){
            cvResult=new Cv();
            JobSeeker jobSeeker=jobSeekerService.getById(jobSeekerId).getData();
            cvResult.setJobSeeker(jobSeeker);
        }

        return new SuccessDataResult<Cv>(cvResult);
    }





}
