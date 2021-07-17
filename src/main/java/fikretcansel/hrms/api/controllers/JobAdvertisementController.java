package fikretcansel.hrms.api.controllers;

import fikretcansel.hrms.business.abstracts.JobAdvertisementService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.ErrorDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.JobAdvertisement;
import fikretcansel.hrms.entities.dto.JobAdvertisementBasicDataDto;
import fikretcansel.hrms.entities.dto.JobAdvertisementPostDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jobAdvertisements")
@CrossOrigin
public class JobAdvertisementController {

    private JobAdvertisementService jobAdvertisementService;

    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService){
        this.jobAdvertisementService=jobAdvertisementService;
    }

    @GetMapping("/getById")
    public DataResult<JobAdvertisement> getById(int id){
        return jobAdvertisementService.getById(id);
    }
    @GetMapping("/getByEmployerId")
    public DataResult<List<JobAdvertisement>> getByEmployerId(int id){
        return jobAdvertisementService.getByEmployerId(id);
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll() {
        return jobAdvertisementService.getAll();
    }

    @PostMapping("add")
    public Result add(@Valid @RequestBody JobAdvertisement entity) {

        return jobAdvertisementService.add(entity);
    }

    @PostMapping("update")
    public Result update(@Valid @RequestBody JobAdvertisement entity) {
        return jobAdvertisementService.update(entity);
    }
    @PostMapping("delete")
    public Result delete(@RequestBody JobAdvertisement entity) {
        return jobAdvertisementService.delete(entity);
    }

    @GetMapping("/getActives")
    public DataResult<List<JobAdvertisementBasicDataDto>> getActiveAdvertisements() {
        return jobAdvertisementService.getActiveAdvertisements();
    }
    @GetMapping("/getActivesCreationDateList")
    public DataResult<List<JobAdvertisementBasicDataDto>> getActiveAdvertisementsByCreationDateList() {
        return jobAdvertisementService.getActiveAdvertisementsByCreationDateList();
    }
    @GetMapping("/getActivesByEmployerId")
    public DataResult<List<JobAdvertisementBasicDataDto>> getActiveAdvertisementsByEmployerId(int employerId) {
        return jobAdvertisementService.getActiveAdvertisementsByEmployerId(employerId);
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
