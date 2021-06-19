package fikretcansel.hrms.api.controllers;

import fikretcansel.hrms.business.abstracts.CandidateLanguageService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.CvLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidateLanguages")
public class CandidateLanguageController {
    private CandidateLanguageService candidateLanguageService;

    @Autowired
    public CandidateLanguageController(CandidateLanguageService candidateLanguageService) {
        super();
        this.candidateLanguageService = candidateLanguageService;
    }

    @GetMapping("/getall")
    public DataResult<List<CvLanguage>> getAll() {
        return candidateLanguageService.getAll();
    }

    @PostMapping("apply")
    public Result apply(@RequestBody CvLanguage entity) {
        return candidateLanguageService.add(entity);
    }


    @PostMapping("update")
    public Result update(@RequestBody CvLanguage entity) {
        return candidateLanguageService.update(entity);
    }


    @PostMapping("delete")
    public Result delete(@RequestBody CvLanguage entity) {
        return candidateLanguageService.delete(entity);
    }
}
