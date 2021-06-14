package fikretcansel.hrms.business.abstracts;

import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.Cv;


import java.util.List;

public interface CvService {
    DataResult<List<Cv>> getAll();

    Result add(Cv entity);

    Result update(Cv entity);

    Result delete(Cv entity);

}
