package fikretcansel.hrms.api.controllers;

import fikretcansel.hrms.business.abstracts.CvService;
import fikretcansel.hrms.business.abstracts.EmailVerificationService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.ErrorDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.Cv;
import fikretcansel.hrms.entities.concretes.EmailVerification;
import fikretcansel.hrms.entities.dto.EmailApplyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;

import java.util.Map;


@RestController
@RequestMapping("/api/emailVerification")
@CrossOrigin
public class EmailVerificationController {

    private EmailVerificationService emailVerificationService;

    @Autowired
    public EmailVerificationController(EmailVerificationService emailVerificationService) {
        super();
        this.emailVerificationService = emailVerificationService;
    }

    @PostMapping("/sendCodeToMail")
    public Result sendCodeToMail(int userId)  {
        return emailVerificationService.sendCodeToMail(userId);
    }
    @PostMapping("verify")
    public Result verify(@RequestBody EmailApplyDto emailApplyDto) {
        return emailVerificationService.verify(emailApplyDto.getCode(),emailApplyDto.getUserId());
    }

    @GetMapping("getIsVerify")
    public DataResult isVerify(int userId){
        return emailVerificationService.getIsVerifiedByUserId(userId);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){

        Map<String,String> validationErrors=new HashMap<String,String>();

        for (FieldError fieldError:exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> error=new ErrorDataResult<Object>(validationErrors,"Doğrulama Hatası");

        return error;
    }

}
