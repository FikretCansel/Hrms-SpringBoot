package fikretcansel.hrms.dataAccess.abstracts;

import fikretcansel.hrms.entities.concretes.SystemPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemPersonnelDao extends JpaRepository<SystemPersonnel,Integer> {

    SystemPersonnel getByEmail(String email);

}
