package fikretcansel.hrms.core.abstracts;

import fikretcansel.hrms.core.utilities.results.concretes.Result;

public interface MailService{

    public Result send(String message,String ToEmailAddress);

}
