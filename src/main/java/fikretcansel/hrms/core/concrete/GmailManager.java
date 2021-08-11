package fikretcansel.hrms.core.concrete;

import fikretcansel.hrms.core.abstracts.MailService;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessResult;
import org.springframework.stereotype.Service;


public class GmailManager implements MailService {
    @Override
    public Result send(String message, String ToEmailAddress) {


        System.out.println(message+"Gmail ile gönderildi");

        return new SuccessResult(message);
    }
}
