package fikretcansel.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import fikretcansel.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{

    boolean existsJobPositionByName(String name);

}
