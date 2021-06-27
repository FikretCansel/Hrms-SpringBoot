package fikretcansel.hrms.dataAccess.abstracts;

import fikretcansel.hrms.entities.concretes.EmailVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailVerificationDao extends JpaRepository<EmailVerification,Integer> {

    EmailVerification getByUserId(int userId);
}
