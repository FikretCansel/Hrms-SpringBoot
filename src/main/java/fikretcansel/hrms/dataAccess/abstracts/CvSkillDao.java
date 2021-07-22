package fikretcansel.hrms.dataAccess.abstracts;

import fikretcansel.hrms.entities.concretes.CvSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CvSkillDao extends JpaRepository<CvSkill,Integer> {
    void deleteAllByCvId(int cvId);
}
