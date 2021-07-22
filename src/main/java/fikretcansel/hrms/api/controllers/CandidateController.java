package fikretcansel.hrms.api.controllers;

import fikretcansel.hrms.business.abstracts.CandidateService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.ErrorDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidateController {
    private CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        super();
        this.candidateService = candidateService;
    }
    @GetMapping("/getall")
    public DataResult<List<Candidate>> getAll() {
        return candidateService.getAll();
    }
    @PostMapping("apply")
    public Result apply(@RequestBody Candidate entity){
        return candidateService.apply(entity);
    }


    @PostMapping("update")
    public Result update(@RequestBody Candidate entity) {
        return candidateService.update(entity);
    }


    @PostMapping("delete")
    public Result delete(@RequestBody Candidate entity) {
        return candidateService.delete(entity);
    }

    @GetMapping("/getAllByJobAdvertisementEmployerId")
    public DataResult<List<Candidate>> getAllByJobAdvertisementEmployerId(int jobAdvertisementId,int employerId) {
        return candidateService.getAllByJobAdvertisementIdEmployerId(jobAdvertisementId,employerId);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){

        Map<String,String> validationErrors=new HashMap<String,String>();

        for (FieldError fieldError:exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> error=new ErrorDataResult<Object>(validationErrors,"Doğrulama Hatası");

        return error;
    }

}