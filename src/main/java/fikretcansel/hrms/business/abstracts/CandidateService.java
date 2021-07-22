package fikretcansel.hrms.business.abstracts;

import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.Candidate;
import fikretcansel.hrms.entities.concretes.City;

import java.util.List;

public interface CandidateService {

    DataResult<List<Candidate>> getAll();

    Result apply(Candidate entity);

    Result update(Candidate entity);

    Result delete(Candidate entity);

    DataResult<Boolean> getViewProfilePermission(int employerId,int jobSeekerId) ;

    DataResult<List<Candidate>> getAllByJobAdvertisementIdEmployerId(int jobAdvertisementId,int employerId);

}
