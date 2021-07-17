package fikretcansel.hrms.dataAccess.abstracts;


import fikretcansel.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import fikretcansel.hrms.entities.concretes.Employer;
import java.util.List;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	Employer getByEmail(String email);
	Employer getById(int id);


	List<Employer> getAllByHrmsVerifyFalse();
}
