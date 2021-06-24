package fikretcansel.hrms.dataAccess.abstracts;

import fikretcansel.hrms.entities.concretes.CvLanguage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CvLanguageDao extends JpaRepository<CvLanguage,Integer> {
}
