package fikretcansel.hrms.business.abstracts;

import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.Employer;
import fikretcansel.hrms.entities.concretes.JobAdvertisement;
import fikretcansel.hrms.entities.concretes.SystemPersonnel;
import fikretcansel.hrms.entities.concretes.User;

import java.util.List;

public interface SystemPersonnelService {

    DataResult<SystemPersonnel> login(User user);
    Result verifyEmployer(int employerId);

    Result verifyJobAdvertisementManager(int jobAdvertisementId);

    DataResult<List<JobAdvertisement>> getAllPendingJobAdvertisements();

    DataResult<SystemPersonnel> existEmail(String email);

    DataResult<List<Employer>> getAllPendingEmployer();
}
