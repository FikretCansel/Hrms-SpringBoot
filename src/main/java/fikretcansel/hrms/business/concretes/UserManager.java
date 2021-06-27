package fikretcansel.hrms.business.concretes;

import fikretcansel.hrms.business.abstracts.UserBase;
import fikretcansel.hrms.business.abstracts.UserService;
import fikretcansel.hrms.dataAccess.abstracts.UserDao;
import fikretcansel.hrms.entities.concretes.User;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    UserDao userDao;

    public UserManager(UserDao userDao){
        this.userDao=userDao;
    }

    @Override
    public User getById(int userId) {
        return userDao.getById(userId);
    }

    @Override
    public int getIdByEmail(String email) {

        return userDao.getIdByEmail(email);
    }
}
