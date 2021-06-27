package fikretcansel.hrms.business.abstracts;


import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.entities.concretes.Employer;

public interface EmployerService extends UserBase<Employer> {
    DataResult<Employer> getById(int id);
}
