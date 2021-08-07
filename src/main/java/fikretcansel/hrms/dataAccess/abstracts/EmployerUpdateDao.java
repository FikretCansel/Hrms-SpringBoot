package fikretcansel.hrms.dataAccess.abstracts;

import fikretcansel.hrms.entities.concretes.EmployerUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerUpdateDao extends JpaRepository<EmployerUpdate,Integer> {

    EmployerUpdate getByEmployerId(int employerId);

}
