package fikretcansel.hrms.dataAccess.abstracts;

import fikretcansel.hrms.entities.concretes.CvEducation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvEducationDao extends JpaRepository<CvEducation,Integer> {
}
