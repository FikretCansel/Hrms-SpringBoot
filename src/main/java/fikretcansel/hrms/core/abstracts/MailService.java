package fikretcansel.hrms.core.abstracts;

import fikretcansel.hrms.core.utilities.results.concretes.Result;


public interface MailService{

    Result send(String message,String toEmailAddress);

}
