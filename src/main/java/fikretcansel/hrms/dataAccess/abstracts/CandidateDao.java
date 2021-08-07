package fikretcansel.hrms.dataAccess.abstracts;

import fikretcansel.hrms.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CandidateDao extends JpaRepository<Candidate,Integer> {

    boolean existsAllByJobAdvertisementEmployerIdAndJobSeekerId(int jobAdvertisementEmployerId,int jobSeekerId);

    boolean existsByJobAdvertisementIdAndJobSeekerId(int jobAdvertisementId,int jobSeekerId);

    Candidate getByJobSeekerId(int userId);

    List<Candidate> getAllByJobAdvertisementId(int jobAdvertisementId);
}
