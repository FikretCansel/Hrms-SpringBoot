package fikretcansel.hrms.api.controllers;

import fikretcansel.hrms.business.abstracts.CandidateService;
import fikretcansel.hrms.business.abstracts.CityService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.Candidate;
import fikretcansel.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidateController {
    private CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        super();
        this.candidateService = candidateService;
    }

    @GetMapping("/getall")
    public DataResult<List<Candidate>> getAll() {
        return candidateService.getAll();
    }
    @PostMapping("apply")
    public Result apply(@RequestBody Candidate entity){
        return candidateService.apply(entity);
    }


    @PostMapping("update")
    public Result update(@RequestBody Candidate entity) {
        return candidateService.update(entity);
    }


    @PostMapping("delete")
    public Result delete(@RequestBody Candidate entity) {
        return candidateService.delete(entity);
    }



}