package fikretcansel.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import fikretcansel.hrms.business.abstracts.JobSeekerService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.JobSeeker;
import fikretcansel.hrms.entities.concretes.User;

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
	@PostMapping("register")
	public Result register(@RequestBody JobSeeker entity, String repeatPassword) throws Exception {
		return jobSeekerService.register(entity,repeatPassword);
	}
	@PostMapping("login")
	public Result login(@RequestBody User user) {
		return jobSeekerService.login(user.getEmail(),user.getPassword());
	}
	

	@PostMapping("update")
	public Result update(@RequestBody JobSeeker entity) {
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
	
}

