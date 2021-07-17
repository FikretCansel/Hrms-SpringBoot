package fikretcansel.hrms.api.controllers;


import fikretcansel.hrms.business.abstracts.EducationService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.ErrorDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.CvEducation;
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
@RequestMapping("/api/educations")
public class EducationController {

    private EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        super();
        this.educationService = educationService;
    }

    @GetMapping("/getall")
    public DataResult<List<CvEducation>> getAll() {
        return educationService.getAll();
    }

    @PostMapping("add")
    public Result add(@Valid @RequestBody CvEducation entity){
        return educationService.add(entity);
    }

    @PostMapping("update")
    public Result update(@Valid @RequestBody CvEducation entity) {
        return educationService.update(entity);
    }

    @PostMapping("delete")
    public Result delete(@RequestBody CvEducation entity) {
        return educationService.delete(entity);
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
