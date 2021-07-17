package fikretcansel.hrms.business.abstracts;

import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.JobAdvertisement;
import fikretcansel.hrms.entities.dto.JobAdvertisementBasicDataDto;

import java.util.List;

public interface JobAdvertisementService {

    DataResult<List<JobAdvertisement>> getAll();

    Result add(JobAdvertisement entity);

    Result update(JobAdvertisement entity);

    Result delete(JobAdvertisement entity);

    DataResult<JobAdvertisement> getById(int id);

    DataResult<List<JobAdvertisement>> getByEmployerId(int id);

    DataResult<List<JobAdvertisementBasicDataDto>> getActiveAdvertisements();

    DataResult<List<JobAdvertisementBasicDataDto>> getActiveAdvertisementsByCreationDateList();

    DataResult<List<JobAdvertisementBasicDataDto>> getActiveAdvertisementsByEmployerId(int employerId);

}
