package fikretcansel.hrms.api.controllers;

import fikretcansel.hrms.business.abstracts.ExperienceService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.ErrorDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.CvExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/experience")
@RestController
public class ExperienceController {

    private ExperienceService experienceService;

    @Autowired
    public ExperienceController(ExperienceService educationService) {
        super();
        this.experienceService = educationService;
    }

    @GetMapping("/getall")
    public DataResult<List<CvExperience>> getAll() {
        return experienceService.getAll();
    }

    @PostMapping("add")
    public Result add(@Valid @RequestBody CvExperience entity){
        return experienceService.add(entity);
    }

    @PostMapping("update")
    public Result update(@Valid @RequestBody CvExperience entity) {
        return experienceService.update(entity);
    }

    @PostMapping("delete")
    public Result delete(@RequestBody CvExperience entity) {
        return experienceService.delete(entity);
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
