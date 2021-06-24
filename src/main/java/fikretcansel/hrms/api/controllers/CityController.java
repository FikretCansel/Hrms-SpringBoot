package fikretcansel.hrms.api.controllers;

import fikretcansel.hrms.business.abstracts.CityService;
import fikretcansel.hrms.business.abstracts.EmployerService;
import fikretcansel.hrms.core.adapters.CloudinaryAdapter;
import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.City;
import fikretcansel.hrms.entities.concretes.Employer;
import fikretcansel.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {
    private CityService cityService;
    private CloudinaryAdapter cloudinaryAdapter;


    @Autowired
    public CityController(CityService cityService) {
        super();
        this.cityService = cityService;
        cloudinaryAdapter = new CloudinaryAdapter();
    }

    @GetMapping("/getall")
    public DataResult<List<City>> getAll() {
        return cityService.getAll();
    }
    @PostMapping("add")
    public Result add(@RequestBody City entity, @RequestBody MultipartFile file) throws IOException {


        cloudinaryAdapter.addPicture(file);
        return cityService.add(entity);
    }


    @PostMapping("update")
    public Result update(City entity) {
        return cityService.update(entity);
    }


    @PostMapping("delete")
    public Result delete(City entity) {
        return cityService.delete(entity);
    }



}
