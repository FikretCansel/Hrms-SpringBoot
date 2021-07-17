package fikretcansel.hrms.dataAccess.abstracts;

import fikretcansel.hrms.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {

    boolean existsAllByJobAdvertisementEmployerIdAndJobSeekerId(int jobAdvertisementEmployerId,int jobSeekerId);

    Candidate getByJobSeekerId(int userId);

}
