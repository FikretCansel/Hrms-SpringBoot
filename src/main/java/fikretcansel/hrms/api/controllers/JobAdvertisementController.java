package fikretcansel.hrms.api.controllers;

import fikretcansel.hrms.business.abstracts.JobAdvertisementService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.JobAdvertisement;
import fikretcansel.hrms.entities.dto.JobAdvertisementDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "api/jobAdvertisement")
public class JobAdvertisementController {

    private JobAdvertisementService jobAdvertisementService;

    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService){
        this.jobAdvertisementService=jobAdvertisementService;
    }


    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll() {
        return jobAdvertisementService.getAll();
    }

    @PostMapping("add")
    public Result add(JobAdvertisementDto entity) {
        return jobAdvertisementService.add(entity);
    }

    @PostMapping("update")
    public Result update(JobAdvertisement entity) {
        return jobAdvertisementService.update(entity);
    }


    @PostMapping("delete")
    public Result delete(JobAdvertisement entity) {
        return jobAdvertisementService.delete(entity);
    }


}
