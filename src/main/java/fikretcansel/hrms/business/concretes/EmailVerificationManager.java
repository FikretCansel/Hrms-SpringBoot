package fikretcansel.hrms.business.concretes;

import fikretcansel.hrms.business.abstracts.EmailVerificationService;
import fikretcansel.hrms.business.abstracts.UserService;
import fikretcansel.hrms.core.abstracts.MailService;
import fikretcansel.hrms.core.concrete.MailManager;
import fikretcansel.hrms.core.utilities.results.concretes.ErrorResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessResult;
import fikretcansel.hrms.dataAccess.abstracts.EmailVerificationDao;
import fikretcansel.hrms.entities.concretes.EmailVerification;
import org.springframework.stereotype.Service;

import java.util.Date;

import static fikretcansel.hrms.business.constants.MessagesTr.progressSuccess;
import static fikretcansel.hrms.business.constants.MessagesTr.wrongCode;

@Service
public class EmailVerificationManager implements EmailVerificationService {

    MailService mailService;
    EmailVerificationDao emailVerificationDao;
    UserService userService;


    public EmailVerificationManager(EmailVerificationDao emailVerificationDao,UserService userService){
        mailService=new MailManager();
        this.emailVerificationDao=emailVerificationDao;
        this.userService=userService;
    }


    @Override
    public Result sendCodeToMail(String email,int userId) {

        int min = 1000;
        int max = 9999;

        int randomInt = (int)Math.floor(Math.random()*(max-min+1)+min);
        String code=randomInt+"";
        String message="Kodunuz : "+randomInt;



        EmailVerification emailVerification=new EmailVerification();
        emailVerification.setCode(code);
        emailVerification.setSaveDate(new Date());
        emailVerification.setUserId(userId);

        if(getByUserId(userId)==null){
            emailVerificationDao.save(emailVerification);
        }else{
            getByUserId(userId).setCode(code);
            getByUserId(userId).setSaveDate(new Date());
        }

        mailService.send(message,email);

        return new SuccessResult(progressSuccess);
    }

    @Override
    public Result verify(String code, int userId) {
        EmailVerification emailVerification = emailVerificationDao.getByUserId(userId);

        if(emailVerification.getCode().equals(emailVerification)){
            emailVerification.setVerified(true);
            return new SuccessResult(progressSuccess);
        }else {
            return new ErrorResult(wrongCode);
        }

    }


    public EmailVerification getByUserId(int userId){
        return emailVerificationDao.getByUserId(userId);
    }

    public boolean getIsVerifiedByUserId(int userId){
        return getByUserId(userId).isVerified();
    }




}
