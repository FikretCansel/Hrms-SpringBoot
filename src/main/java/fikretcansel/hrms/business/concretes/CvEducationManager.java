package fikretcansel.hrms.business.concretes;

import fikretcansel.hrms.business.abstracts.EducationService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessResult;
import fikretcansel.hrms.dataAccess.abstracts.CvEducationDao;
import fikretcansel.hrms.entities.concretes.CvEducation;
import org.springframework.stereotype.Service;

import java.util.List;

import static fikretcansel.hrms.business.constants.MessagesTr.deleteSuccess;
import static fikretcansel.hrms.business.constants.MessagesTr.saveSuccess;

@Service
public class CvEducationManager implements EducationService {
    private CvEducationDao educationDao;

    public CvEducationManager(CvEducationDao educationDao) {
        this.educationDao=educationDao;
    }


    @Override
    public DataResult<List<CvEducation>> getAll() {
        return new SuccessDataResult<List<CvEducation>>(educationDao.findAll());
    }

    @Override
    public Result add(CvEducation entity) {


        educationDao.save(entity);
        return new SuccessResult(saveSuccess);
    }

    @Override
    public Result update(CvEducation entity) {
        return null;
    }

    @Override
    public Result delete(CvEducation entity) {
        educationDao.delete(entity);
        return new SuccessResult(deleteSuccess);
    }

    @Override
    public Result deleteAllByCvId(int cvId) {
        educationDao.deleteAllByCvId(cvId);
        return new SuccessResult(deleteSuccess);
    }

}
