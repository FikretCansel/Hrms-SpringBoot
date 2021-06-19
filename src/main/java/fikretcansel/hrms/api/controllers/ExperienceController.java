package fikretcansel.hrms.api.controllers;

import fikretcansel.hrms.business.abstracts.EducationService;
import fikretcansel.hrms.business.abstracts.ExperienceService;
import fikretcansel.hrms.business.concretes.ExperienceManager;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.Education;
import fikretcansel.hrms.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/experience")
@RestController
public class ExperienceController {

    private ExperienceService experienceService;

    @Autowired
    public ExperienceController(ExperienceService educationService) {
        super();
        this.experienceService = educationService;
    }

    @GetMapping("/getall")
    public DataResult<List<Experience>> getAll() {
        return experienceService.getAll();
    }

    @PostMapping("add")
    public Result add(@RequestBody Experience entity){
        return experienceService.add(entity);
    }

    @PostMapping("update")
    public Result update(@RequestBody Experience entity) {
        return experienceService.update(entity);
    }

    @PostMapping("delete")
    public Result delete(@RequestBody Experience entity) {
        return experienceService.delete(entity);
    }

}
