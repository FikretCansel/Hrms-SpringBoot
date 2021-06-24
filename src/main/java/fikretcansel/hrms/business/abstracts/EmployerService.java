package fikretcansel.hrms.business.abstracts;


import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.entities.concretes.Employer;

public interface EmployerService extends UserService<Employer>{
    DataResult<Employer> getById(int id);
}
