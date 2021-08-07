package fikretcansel.hrms.business.abstracts;


import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;
import fikretcansel.hrms.entities.concretes.Employer;
import fikretcansel.hrms.entities.concretes.EmployerUpdate;

public interface EmployerService extends UserBase<Employer> {
    DataResult<Employer> getById(int id);

    Result update(EmployerUpdate entity);

}
