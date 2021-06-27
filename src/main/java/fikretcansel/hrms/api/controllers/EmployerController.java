package fikretcansel.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fikretcansel.hrms.core.utilities.results.concretes.ErrorDataResult;
import fikretcansel.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import fikretcansel.hrms.business.abstracts.EmployerService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.Employer;
import fikretcansel.hrms.entities.concretes.User;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin

public class EmployerController {

	
private EmployerService employerService;
	
	@Autowired
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}

	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll() {
		return employerService.getAll();
	}
	@PostMapping("register")
	public Result register(@Valid @RequestBody Employer entity) {
		return employerService.register(entity);
	}
	@PostMapping("login")
	public Result login(@Valid @RequestBody User user) {
		return employerService.login(user.getEmail(),user.getPassword());
	}

	@PostMapping("update")
	public Result update(@Valid @RequestBody Employer entity) {
		return employerService.update(entity);
	}


	@PostMapping("delete")
	public Result delete(@RequestBody Employer entity) {
		return employerService.delete(entity);
	}
	@GetMapping("/getById")
	public DataResult<Employer> getById(int id) {
		return employerService.getById(id);
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
