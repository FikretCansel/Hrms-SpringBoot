package fikretcansel.hrms.api.controllers;


import fikretcansel.hrms.business.abstracts.EducationService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
public class EducationController {

    private EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        super();
        this.educationService = educationService;
    }

    @GetMapping("/getall")
    public DataResult<List<Education>> getAll() {
        return educationService.getAll();
    }

    @PostMapping("add")
    public Result add(@RequestBody Education entity){
        return educationService.add(entity);
    }

    @PostMapping("update")
    public Result update(@RequestBody Education entity) {
        return educationService.update(entity);
    }

    @PostMapping("delete")
    public Result delete(@RequestBody Education entity) {
        return educationService.delete(entity);
    }


}
