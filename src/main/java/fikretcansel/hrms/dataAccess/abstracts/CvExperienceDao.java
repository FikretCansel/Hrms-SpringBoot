package fikretcansel.hrms.dataAccess.abstracts;

import fikretcansel.hrms.entities.concretes.CvExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvExperienceDao extends JpaRepository<CvExperience,Integer> {
}
