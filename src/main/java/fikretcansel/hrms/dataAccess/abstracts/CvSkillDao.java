package fikretcansel.hrms.dataAccess.abstracts;

import fikretcansel.hrms.entities.concretes.CvSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvSkillDao extends JpaRepository<CvSkill,Integer> {
}
