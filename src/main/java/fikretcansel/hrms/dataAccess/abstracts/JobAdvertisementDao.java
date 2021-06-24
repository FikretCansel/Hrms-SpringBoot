package fikretcansel.hrms.dataAccess.abstracts;

import fikretcansel.hrms.entities.concretes.JobAdvertisement;
import fikretcansel.hrms.entities.dto.JobAdvertisementDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {

    JobAdvertisement getByIsActive(boolean active);

    JobAdvertisement getById(int id);

    List<JobAdvertisement> getByEmployerId(int id);

    @Query("Select new fikretcansel.hrms.entities.dto.JobAdvertisementDto"
            + "(ja.id, ja.employer.companyName,ja.jobPosition.name,ja.openPositionCount,ja.creationDate,ja.lastApplyDate)" +
            "From JobAdvertisement ja where ja.isActive=true")
    List<JobAdvertisementDto> getActiveAdvertisements();

    @Query("Select new fikretcansel.hrms.entities.dto.JobAdvertisementDto"
            + "(ja.id, ja.employer.companyName,ja.jobPosition.name,ja.openPositionCount,ja.creationDate,ja.lastApplyDate)" +
            "From JobAdvertisement ja where ja.isActive=true order by ja.creationDate asc")
    List<JobAdvertisementDto> getActiveAdvertisementsByCreationDateList();

    @Query("Select new fikretcansel.hrms.entities.dto.JobAdvertisementDto"
            + "(ja.id, ja.employer.companyName,ja.jobPosition.name,ja.openPositionCount,ja.creationDate,ja.lastApplyDate)" +
            "From JobAdvertisement ja where ja.isActive=true and ja.employer.id=:employerId")
    List<JobAdvertisementDto> getActiveAdvertisementsByEmployerId(int employerId);

}
