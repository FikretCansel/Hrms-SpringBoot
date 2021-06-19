package fikretcansel.hrms.dataAccess.abstracts;

import fikretcansel.hrms.entities.concretes.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationDao extends JpaRepository<Education,Integer> {
}
