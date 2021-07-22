package fikretcansel.hrms.dataAccess.abstracts;

import fikretcansel.hrms.entities.concretes.CvLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CvLanguageDao extends JpaRepository<CvLanguage,Integer> {
    void deleteAllByCvId(int cvId);
}
