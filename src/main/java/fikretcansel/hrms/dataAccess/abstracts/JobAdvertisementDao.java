package fikretcansel.hrms.dataAccess.abstracts;

import fikretcansel.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {

}
