package fikretcansel.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import fikretcansel.hrms.business.abstracts.JobPositionService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.JobPosition;

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
	public Result add(@RequestBody JobPosition entity) {
		return jobPositionService.add(entity);
	}

	@PostMapping("update")
	public Result update(@RequestBody JobPosition entity) {
		return jobPositionService.update(entity);
	}


	@PostMapping("delete")
	public Result delete(@RequestBody JobPosition entity) {
		return jobPositionService.delete(entity);
	}
	
}
