package fikretcansel.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import fikretcansel.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	Employer getByEmail(String email);
	Employer getById(int id);
}
