package fikretcansel.hrms.business.abstracts;

import java.util.List;

import fikretcansel.hrms.core.utilities.results.concretes.DataResult;
import fikretcansel.hrms.core.utilities.results.concretes.Result;

public interface UserBase<T>{
	
	DataResult register(T entity);
	DataResult login(String email,String password);
	DataResult<List<T>> getAll();
	Result delete(T entity);
}
