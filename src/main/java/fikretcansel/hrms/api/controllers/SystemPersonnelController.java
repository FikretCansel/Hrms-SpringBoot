package fikretcansel.hrms.api.controllers;

import fikretcansel.hrms.business.abstracts.SystemPersonnelService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.Employer;
import fikretcansel.hrms.entities.concretes.JobAdvertisement;
import fikretcansel.hrms.entities.concretes.SystemPersonnel;
import fikretcansel.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(name = "admin")
@RestController
@CrossOrigin
public class SystemPersonnelController {
    private SystemPersonnelService systemPersonnelService;

    @Autowired
    public SystemPersonnelController(SystemPersonnelService systemPersonnelService){
        this.systemPersonnelService=systemPersonnelService;
    }


    @PostMapping("/verifyJobAdvertisementManager")
    public Result register(@Valid @RequestBody int jobAdvertisementId) {
        return systemPersonnelService.verifyJobAdvertisementManager(jobAdvertisementId);
    }

    @PostMapping("/verifyEmployer")
    public Result verifyEmployer(@Valid @RequestBody int employerId) {
        return systemPersonnelService.verifyEmployer(employerId);
    }

    @PostMapping("/login")
    public Result login(@Valid @RequestBody User user) {
        return systemPersonnelService.login(user);
    }
    @GetMapping("/getAllPendingEmployer")
    public DataResult<List<Employer>> getAllPendingEmployer() {
        return systemPersonnelService.getAllPendingEmployer();
    }
    @GetMapping("/getAllPendingJobAdvertisements")
    public DataResult<List<JobAdvertisement>> getAllPendingJobAdvertisements() {
        return systemPersonnelService.getAllPendingJobAdvertisements();
    }


}
