package fikretcansel.hrms.business.abstracts;

import fikretcansel.hrms.entities.concretes.User;

public interface UserService {

    User getById(int userId);

    int getIdByEmail(String email);

}
