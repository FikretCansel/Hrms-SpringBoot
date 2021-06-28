package fikretcansel.hrms.business.concretes;

import fikretcansel.hrms.business.abstracts.EmailVerificationService;
import fikretcansel.hrms.business.abstracts.UserService;
import fikretcansel.hrms.core.abstracts.MailService;
import fikretcansel.hrms.core.concrete.MailManager;
import fikretcansel.hrms.core.utilities.results.concretes.*;
import fikretcansel.hrms.dataAccess.abstracts.EmailVerificationDao;
import fikretcansel.hrms.entities.concretes.EmailVerification;
import fikretcansel.hrms.entities.concretes.User;
import org.springframework.stereotype.Service;

import java.util.Date;

import static fikretcansel.hrms.business.constants.MessagesTr.*;

@Service
public class EmailVerificationManager implements EmailVerificationService {

    MailService mailService;
    EmailVerificationDao emailVerificationDao;
    UserService userService;


    public EmailVerificationManager(EmailVerificationDao emailVerificationDao,UserService userService,MailService mailService){
        this.mailService=mailService;
        this.emailVerificationDao=emailVerificationDao;
        this.userService=userService;
    }


    @Override
    public Result sendCodeToMail(int userId) {

        int min = 1000;
        int max = 9999;

        int randomInt = (int)Math.floor(Math.random()*(max-min+1)+min);
        String code=randomInt+"";
        String message="Kodunuz : "+randomInt;

        User user=userService.getById(userId);

        EmailVerification emailVerification=new EmailVerification();
        emailVerification.setCode(code);
        emailVerification.setSaveDate(new Date());
        emailVerification.setUserId(user.getId());




        if(getByUserId(userId)==null){
            emailVerificationDao.save(emailVerification);
        }else{
            emailVerification.setUserId(getByUserId(userId).getId());
            emailVerificationDao.save(emailVerification);

        }

        mailService.send(message,user.getEmail());

        return new SuccessResult(progressSuccess);
    }


    @Override
    public Result verify(String code, int userId) {
        EmailVerification emailVerification = emailVerificationDao.getByUserId(userId);

        if(emailVerification.isVerified()){
            return new ErrorResult(alreadyVerified);
        }


        if(!emailVerification.getCode().equals(emailVerification.getCode())){
            return new ErrorResult(wrongCode);
        }


        long limitTimeMin=10;
        if(calculatePassingTime(emailVerification.getSaveDate())>limitTimeMin){
            sendCodeToMail(userId);
            return new ErrorResult(timeUp);
        }


        //-----
        emailVerification.setVerified(true);
        emailVerificationDao.save(emailVerification);
        return new SuccessResult(progressSuccess);
    }
    private long calculatePassingTime(Date pastDate){
        long estimatedTime =System.currentTimeMillis()-pastDate.getTime();
        long second=estimatedTime/1000;
        long minute=second/60;
        return minute;
    }


    public EmailVerification getByUserId(int userId){
        return emailVerificationDao.getByUserId(userId);
    }

    public DataResult<Boolean> getIsVerifiedByUserId(int userId){
        return new SuccessDataResult<Boolean>(emailVerificationDao.getByUserId(userId).isVerified());
    }




}
