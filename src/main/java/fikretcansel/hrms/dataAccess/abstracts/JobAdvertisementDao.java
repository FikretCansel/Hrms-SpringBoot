package fikretcansel.hrms.dataAccess.abstracts;

import fikretcansel.hrms.entities.concretes.JobAdvertisement;
import fikretcansel.hrms.entities.dto.JobAdvertisementBasicDataDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {

    JobAdvertisement getByIsActive(boolean active);

    JobAdvertisement getById(int id);

    List<JobAdvertisement> getAllByHrmsVerifyFalse();

    List<JobAdvertisement> getByEmployerId(int id);

    @Query("Select new fikretcansel.hrms.entities.dto.JobAdvertisementBasicDataDto"
            + "(ja.id, ja.employer.companyName,ja.jobPosition.name,ja.openPositionCount,ja.creationDate,ja.lastApplyDate)" +
            "From JobAdvertisement ja where ja.isActive=true")
    List<JobAdvertisementBasicDataDto> getActiveAdvertisements();

    @Query("Select new fikretcansel.hrms.entities.dto.JobAdvertisementBasicDataDto"
            + "(ja.id, ja.employer.companyName,ja.jobPosition.name,ja.openPositionCount,ja.creationDate,ja.lastApplyDate)" +
            "From JobAdvertisement ja where ja.isActive=true order by ja.creationDate asc")
    List<JobAdvertisementBasicDataDto> getActiveAdvertisementsByCreationDateList();

    @Query("Select new fikretcansel.hrms.entities.dto.JobAdvertisementBasicDataDto"
            + "(ja.id, ja.employer.companyName,ja.jobPosition.name,ja.openPositionCount,ja.creationDate,ja.lastApplyDate)" +
            "From JobAdvertisement ja where ja.isActive=true and ja.employer.id=:employerId")
    List<JobAdvertisementBasicDataDto> getActiveAdvertisementsByEmployerId(int employerId);

}
