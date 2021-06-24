package fikretcansel.hrms.api.controllers;

import fikretcansel.hrms.business.abstracts.CvLanguageService;
import fikretcansel.hrms.business.abstracts.EducationService;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.CvLanguage;
import fikretcansel.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cvLanguages")
public class CvLanguageController {


    private CvLanguageService cvLanguageService;

    @Autowired
    public CvLanguageController(CvLanguageService cvLanguageService) {
        super();
        this.cvLanguageService = cvLanguageService;
    }

    @GetMapping("/getall")
    public DataResult<List<CvLanguage>> getAll() {
        return cvLanguageService.getAll();
    }

    @PostMapping("add")
    public Result add(@RequestBody CvLanguage entity){
        return cvLanguageService.add(entity);
    }

    @PostMapping("update")
    public Result update(@RequestBody CvLanguage entity) {
        return cvLanguageService.update(entity);
    }

    @PostMapping("delete")
    public Result delete(@RequestBody CvLanguage entity) {
        return cvLanguageService.delete(entity);
    }
}
