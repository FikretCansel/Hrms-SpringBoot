package fikretcansel.hrms.api.controllers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fikretcansel.hrms.core.utilities.results.concretes.ErrorDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import fikretcansel.hrms.business.abstracts.JobSeekerService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.JobSeeker;
import fikretcansel.hrms.entities.concretes.User;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/jobSeekers")
@CrossOrigin
public class JobSeekerController {

	
private JobSeekerService jobSeekerService;
	
	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll() {
		return jobSeekerService.getAll();
	}
	@PostMapping(  "register")
	public Result register(@Valid @RequestBody JobSeeker entity) throws Exception {
		return jobSeekerService.register(entity);
	}
	@PostMapping("login")
	public Result login(@Valid @RequestBody User user) {
		return jobSeekerService.login(user.getEmail(),user.getPassword());
	}
	

	@PostMapping("update")
	public Result update(@Valid @RequestBody JobSeeker entity) {
		return jobSeekerService.update(entity);
	}


	@PostMapping("delete")
	public Result delete(@RequestBody JobSeeker entity) {
		return jobSeekerService.delete(entity);
	}

	@GetMapping("/getById")
	public DataResult<JobSeeker> getById(int id)
	{
		return jobSeekerService.getById(id);
	}
	@PostMapping("uploadProfilePhoto")
	public Result uploadProfilePhoto(MultipartFile multipartFile,int userId) throws IOException {
		return jobSeekerService.uploadProfilePhoto(multipartFile,userId);
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

