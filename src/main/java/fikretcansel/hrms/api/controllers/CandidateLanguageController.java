package fikretcansel.hrms.api.controllers;

import fikretcansel.hrms.business.abstracts.CandidateLanguageService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.ErrorDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.CvLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/candidateLanguages")
public class CandidateLanguageController {
    private CandidateLanguageService candidateLanguageService;

    @Autowired
    public CandidateLanguageController(CandidateLanguageService candidateLanguageService) {
        super();
        this.candidateLanguageService = candidateLanguageService;
    }

    @GetMapping("/getall")
    public DataResult<List<CvLanguage>> getAll() {
        return candidateLanguageService.getAll();
    }

    @PostMapping("apply")
    public Result apply(@Valid @RequestBody CvLanguage entity) {
        return candidateLanguageService.add(entity);
    }


    @PostMapping("update")
    public Result update(@Valid @RequestBody CvLanguage entity) {
        return candidateLanguageService.update(entity);
    }


    @PostMapping("delete")
    public Result delete(@Valid @RequestBody CvLanguage entity) {
        return candidateLanguageService.delete(entity);
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
