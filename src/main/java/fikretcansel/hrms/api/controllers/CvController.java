package fikretcansel.hrms.api.controllers;


import fikretcansel.hrms.business.abstracts.CityService;
import fikretcansel.hrms.business.abstracts.CvService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.ErrorDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.City;
import fikretcansel.hrms.entities.concretes.Cv;
import fikretcansel.hrms.entities.dto.CvDetailDto;
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
@RequestMapping("/api/cvs")
@CrossOrigin
public class CvController {

    private CvService cvService;

    @Autowired
    public CvController(CvService cvService) {
        super();
        this.cvService = cvService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Cv>> getAll() {
        return cvService.getAll();
    }
    @PostMapping("add")
    public Result add(@Valid @RequestBody Cv entity){
        return cvService.add(entity);
    }

    @PostMapping("update")
    public Result update(@Valid @RequestBody Cv entity) {
        return cvService.update(entity);
    }

    @PostMapping("delete")
    public Result delete(@RequestBody Cv entity) {
        return cvService.delete(entity);
    }

    @GetMapping("/getById")
    public DataResult<Cv> getAllById(int id) {
        return cvService.getById(id);
    }
    @GetMapping("/getByJobSeekerIdForEmployers")
    public DataResult<Cv> getByJobSeekerIdForEmployers(int jobSeekerId,int employerId) {

        return cvService.getByJobSeekerIdForEmployers(jobSeekerId,employerId);
    }
    @GetMapping("/getByJobSeekerIdForItSelf")
    public DataResult<Cv> getByJobSeekerIdForItSelf(int jobSeekerId) {

        return cvService.getByJobSeekerIdForItSelf(jobSeekerId);
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
