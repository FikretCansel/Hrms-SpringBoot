package fikretcansel.hrms.api.controllers;


import fikretcansel.hrms.business.abstracts.CityService;
import fikretcansel.hrms.business.abstracts.CvService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.City;
import fikretcansel.hrms.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cvs")
public class CvController {

    private CvService cvService;

    @Autowired
    public CvController(CvService cvService) {
        super();
        this.cvService = cvService;
    }

    @GetMapping("/getall")
    public DataResult<List<Cv>> getAll() {
        return cvService.getAll();
    }
    @PostMapping("add")
    public Result add(@RequestBody Cv entity){
        return cvService.add(entity);
    }

    @PostMapping("update")
    public Result update(@RequestBody Cv entity) {
        return cvService.update(entity);
    }

    @PostMapping("delete")
    public Result delete(@RequestBody Cv entity) {
        return cvService.delete(entity);
    }

    @GetMapping("/getallById")
    public DataResult<Cv> getAllById(int id) {
        return cvService.getAllById(id);
    }
    @GetMapping("/getAllByJobSeekerId")
    public DataResult<List<Cv>> getByJobSeekerId(int jobSeekerId) {
        return cvService.getAllByJobSeekerId(jobSeekerId);
    }

}
