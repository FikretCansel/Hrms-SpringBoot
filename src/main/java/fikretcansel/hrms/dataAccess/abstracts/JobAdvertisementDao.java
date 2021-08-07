package fikretcansel.hrms.dataAccess.abstracts;

import fikretcansel.hrms.entities.concretes.JobAdvertisement;
import fikretcansel.hrms.entities.dto.JobAdvertisementBasicDataDto;
import fikretcansel.hrms.entities.dto.JobAdvertisementFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

//    @Query("Select j  from JobAdvertisement j where ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
//            + "and ((:#{#filter.jobTitleId}) IS NULL OR j.jobPosition.id IN (:#{#filter.jobTitleId}))"
//            +" and ((:#{#filter.workTimeId}) IS NULL OR j..id IN (:#{#filter.workTimeId}))"
//            +" and ((:#{#filter.workTypeId}) IS NULL OR j.isFullTime IN (:#{#filter.workTypeId}))"
//            + "and j.isActive = true Order By j.createDate Desc ")
//    public Page<JobAdvertisement> getByFilter(@Param("filter") JobAdvertisementFilter jobAdvertFilter, Pageable pageable);

}
