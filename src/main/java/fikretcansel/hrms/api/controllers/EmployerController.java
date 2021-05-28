package fikretcansel.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fikretcansel.hrms.business.abstracts.EmployerService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.Employer;
import fikretcansel.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/employers")
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
	public Result register(Employer entity,String repeatPassword) throws Exception {
		return employerService.register(entity,repeatPassword);
	}
	@PostMapping("login")
	public Result login(User user) {
		return employerService.login(user.getEmail(),user.getPassword());
	}

	@PostMapping("update")
	public Result update(Employer entity) {
		return employerService.update(entity);
	}


	@PostMapping("delete")
	public Result delete(Employer entity) {
		return employerService.delete(entity);
	}
	
}
