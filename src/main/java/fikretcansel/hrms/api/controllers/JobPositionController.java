package fikretcansel.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fikretcansel.hrms.core.utilities.results.concretes.ErrorDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import fikretcansel.hrms.business.abstracts.JobPositionService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.JobPosition;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/jobPositions")
public class JobPositionController {

	
private JobPositionService jobPositionService;
	
	@Autowired
	public JobPositionController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll() {
		return jobPositionService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@Valid @RequestBody JobPosition entity) {
		return jobPositionService.add(entity);
	}

	@PostMapping("update")
	public Result update(@Valid @RequestBody JobPosition entity) {
		return jobPositionService.update(entity);
	}


	@PostMapping("delete")
	public Result delete(@RequestBody JobPosition entity) {
		return jobPositionService.delete(entity);
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
