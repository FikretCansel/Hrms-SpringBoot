package fikretcansel.hrms.dataAccess.abstracts;

import fikretcansel.hrms.entities.concretes.CvEducation;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CvEducationDao extends JpaRepository<CvEducation,Integer> {

    void deleteAllByCvId(int cvId);
}
