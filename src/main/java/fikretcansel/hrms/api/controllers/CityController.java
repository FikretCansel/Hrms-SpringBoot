package fikretcansel.hrms.api.controllers;

import fikretcansel.hrms.business.abstracts.CityService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.ErrorDataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cities")
public class CityController {
    private CityService cityService;
   // private CloudinaryAdapter cloudinaryAdapter;


    @Autowired
    public CityController(CityService cityService) {
        super();
        this.cityService = cityService;
       // cloudinaryAdapter = new CloudinaryAdapter();
    }

    @GetMapping("/getall")
    public DataResult<List<City>> getAll() {
        return cityService.getAll();
    }
    @PostMapping("add")
    public Result add(@Valid @RequestBody City entity) throws IOException {


        //cloudinaryAdapter.addPicture(file);
        return cityService.add(entity);
    }


    @PostMapping("update")
    public Result update(@Valid City entity) {

        return cityService.update(entity);
    }


    @PostMapping("delete")
    public Result delete(City entity) {
        return cityService.delete(entity);
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
