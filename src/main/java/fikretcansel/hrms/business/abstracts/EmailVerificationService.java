package fikretcansel.hrms.business.abstracts;

import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.EmailVerification;

public interface EmailVerificationService {

     Result sendCodeToMail(String email,int userId);

     Result verify(String code,int userId);

     EmailVerification getByUserId(int userId);

    boolean getIsVerifiedByUserId(int userId);
}
