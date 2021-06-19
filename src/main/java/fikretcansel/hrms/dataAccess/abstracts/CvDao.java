package fikretcansel.hrms.dataAccess.abstracts;

import fikretcansel.hrms.entities.concretes.Cv;
import fikretcansel.hrms.entities.dto.CvDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CvDao extends JpaRepository<Cv,Integer> {
//    @Query("Select new fikretcansel.hrms.entities.dto.CvDetailDto (cv,ed,ex)" +
//            " from Cv cv left join Education ed left join Experience ex left join CvLanguage " +
//            "WHERE cv.id =:id")
//    CvDetailDto getCvDetailById(int id);

    Cv getAllById(int id);

    List<Cv> getAllByJobSeekerId(int jobSeekerId);
}
