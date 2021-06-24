package fikretcansel.hrms.dataAccess.abstracts;

import fikretcansel.hrms.entities.concretes.Cv;
import fikretcansel.hrms.entities.concretes.CvLanguage;
import fikretcansel.hrms.entities.concretes.Education;
import fikretcansel.hrms.entities.concretes.Experience;
import fikretcansel.hrms.entities.dto.CvDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CvDao extends JpaRepository<Cv,Integer> {



    Cv getAllById(int id);

    Cv getAllByJobSeekerId(int jobSeekerId);
}
