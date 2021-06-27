package fikretcansel.hrms.dataAccess.abstracts;





import org.springframework.data.jpa.repository.JpaRepository;

import fikretcansel.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	User getByEmail(String email);
	
	int getIdByEmail(String email);

	User getById(int id);
}
