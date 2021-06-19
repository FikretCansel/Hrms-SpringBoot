package fikretcansel.hrms.business.abstracts;

import java.util.List;

import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;

public interface UserService<T>{
	
	DataResult register(T entity,String repeatPassword);
	DataResult login(String email,String password);
	DataResult<List<T>> getAll();
	Result update(T entity);
	Result delete(T entity);
	
	Result validation(T entity);
}
