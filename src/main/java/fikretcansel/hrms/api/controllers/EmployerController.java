package fikretcansel.hrms.api.controllers;

import java.util.List;

import fikretcansel.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fikretcansel.hrms.business.abstracts.EmployerService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.Employer;
import fikretcansel.hrms.entities.concretes.User;

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
	public Result register(@RequestBody Employer entity, String repeatPassword) {
		return employerService.register(entity,repeatPassword);
	}
	@PostMapping("login")
	public Result login(@RequestBody User user) {
		return employerService.login(user.getEmail(),user.getPassword());
	}

	@PostMapping("update")
	public Result update(@RequestBody Employer entity) {
		return employerService.update(entity);
	}


	@PostMapping("delete")
	public Result delete(@RequestBody Employer entity) {
		return employerService.delete(entity);
	}
	
}
