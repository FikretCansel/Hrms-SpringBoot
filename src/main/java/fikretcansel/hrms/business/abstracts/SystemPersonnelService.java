package fikretcansel.hrms.business.abstracts;

import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.*;

import java.util.List;

public interface SystemPersonnelService {

    DataResult<SystemPersonnel> login(User user);
    Result verifyEmployer(int employerId);

    Result confirmEmployerUpdate(int employerId);

    Result verifyJobAdvertisementManager(int jobAdvertisementId);

    DataResult<List<JobAdvertisement>> getAllPendingJobAdvertisements();

    DataResult<SystemPersonnel> existEmail(String email);

    DataResult<List<Employer>> getAllPendingEmployer();

    Result update(SystemPersonnel entity);
}
