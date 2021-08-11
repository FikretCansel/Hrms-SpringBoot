package fikretcansel.hrms.business.abstracts;

import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessDataResult;
import fikretcansel.hrms.entities.concretes.JobAdvertisement;
import fikretcansel.hrms.entities.dto.JobAdvertisementBasicDataDto;
import fikretcansel.hrms.entities.dto.JobAdvertisementFilter;
import fikretcansel.hrms.entities.dto.JobAdvertisementHomeDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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

    DataResult<List<JobAdvertisementHomeDto>> getAllFilterAndPage(int pageNo, int pageSize, JobAdvertisementFilter advertFilter);
}
