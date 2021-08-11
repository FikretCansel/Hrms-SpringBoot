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
    public Result sendCodeToMail(int userId)  {
        User user=userService.getById(userId);

        if(user==null){
            return new ErrorResult(userNotFound);
        }


        int min = 1000;
        int max = 9999;
        int randomInt = (int)Math.floor(Math.random()*(max-min+1)+min);
        String code=randomInt+"";
        String message="Kodunuz : "+randomInt;


        EmailVerification newEmailVerification=new EmailVerification();

        newEmailVerification.setCode(code);
        newEmailVerification.setSaveDate(new Date());
        newEmailVerification.setUserId(userId);

        EmailVerification fromDatabaseVerify=emailVerificationDao.getByUserId(userId);

        if(fromDatabaseVerify!=null) {
            //If exist
            if(fromDatabaseVerify.isVerified()){
                return new ErrorResult(alreadyVerified);
            }

            newEmailVerification.setId(fromDatabaseVerify.getId());
        }
        emailVerificationDao.save(newEmailVerification);
        mailService.send(message,user.getEmail());

        return new SuccessResult(progressSuccess);
    }


    @Override
    public Result verify(String code, int userId) {
        EmailVerification emailVerification = emailVerificationDao.getByUserId(userId);

        if(emailVerification==null){
            return new ErrorResult(userNotFound);
        }

        if(emailVerification.isVerified()){
            return new ErrorResult(alreadyVerified);
        }

        System.out.println("veri tabanından gelen "+ emailVerification.getCode());
        System.out.println("girilen"+code);

        if(!emailVerification.getCode().equals(code)){
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


    @Override
    public DataResult<Boolean> getIsVerifiedByUserId(int userId){

        EmailVerification userVerificationData =emailVerificationDao.getByUserId(userId);

        if(userVerificationData==null){
            return new ErrorDataResult<Boolean>(false);
        }

        return new SuccessDataResult<Boolean>(userVerificationData.isVerified());
    }




}
