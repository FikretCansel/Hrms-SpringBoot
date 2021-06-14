package fikretcansel.hrms.business.abstracts;

import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.City;
import fikretcansel.hrms.entities.concretes.JobPosition;

import java.util.List;

public interface CityService {

    DataResult<List<City>> getAll();

    Result add(City entity);

    Result update(City entity);

    Result delete(City entity);


}
