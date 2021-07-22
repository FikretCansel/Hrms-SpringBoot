package fikretcansel.hrms.dataAccess.abstracts;

import fikretcansel.hrms.entities.concretes.CvExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CvExperienceDao extends JpaRepository<CvExperience,Integer> {
    void deleteAllByCvId(int cvId);
}
