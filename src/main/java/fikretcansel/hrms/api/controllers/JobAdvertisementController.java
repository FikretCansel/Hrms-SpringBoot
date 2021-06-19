package fikretcansel.hrms.api.controllers;

import fikretcansel.hrms.business.abstracts.JobAdvertisementService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.core.utilities.results.concretes.SuccessDataResult;
import fikretcansel.hrms.entities.concretes.JobAdvertisement;
import fikretcansel.hrms.entities.dto.JobAdvertisementDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisements")
@CrossOrigin
public class JobAdvertisementController {

    private JobAdvertisementService jobAdvertisementService;

    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService){
        this.jobAdvertisementService=jobAdvertisementService;
    }

    @GetMapping("/getById")
    public SuccessDataResult<JobAdvertisement> getById(int id){
        return jobAdvertisementService.getById(id);
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll() {
        return jobAdvertisementService.getAll();
    }

    @PostMapping("add")
    public Result add(@RequestBody JobAdvertisement entity) {
        return jobAdvertisementService.add(entity);
    }

    @PostMapping("update")
    public Result update(@RequestBody JobAdvertisement entity) {
        return jobAdvertisementService.update(entity);
    }
    @PostMapping("delete")
    public Result delete(@RequestBody JobAdvertisement entity) {
        return jobAdvertisementService.delete(entity);
    }

    @GetMapping("/getActives")
    public DataResult<List<JobAdvertisementDto>> getActiveAdvertisements() {
        return jobAdvertisementService.getActiveAdvertisements();
    }
    @GetMapping("/getActivesCreationDateList")
    public DataResult<List<JobAdvertisementDto>> getActiveAdvertisementsByCreationDateList() {
        return jobAdvertisementService.getActiveAdvertisementsByCreationDateList();
    }
    @GetMapping("/getActivesByEmployerId")
    public DataResult<List<JobAdvertisementDto>> getActiveAdvertisementsByEmployerId(int employerId) {
        return jobAdvertisementService.getActiveAdvertisementsByEmployerId(employerId);
    }

}
