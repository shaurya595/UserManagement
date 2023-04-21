package com.Geekster.UserManagement.Service;

import ch.qos.logback.classic.util.LogbackMDCAdapter;
import com.Geekster.UserManagement.Repository.UserDao;
import com.Geekster.UserManagement.Service.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public List<User> getAllUser() {
        return userDao.getUserFromData();
    }

    public String addMyUser(User user) {
        boolean insertionStatus = userDao.save(user);
        if (insertionStatus) {
            return "user Save Successfully";
        } else {
            return " not saved";
        }
    }

    public User getUserBasedOnId(String id) {
        List<User> UserRightNow = userDao.getUserFromData();
        for (User user : UserRightNow) {
            if (user.getUserId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public String removeUserById(String id) {
        boolean deleteResponse = false;
        String status;
        if (id != null) {
            List<User> UserRightNow = userDao.getUserFromData();
            for (User user : UserRightNow) {
                if (user.getUserId().equals(id)) {
                    deleteResponse = userDao.remove(user);
                    if(deleteResponse){
                        status = "user"+id+"deleted";
                    }else{
                        status = "user"+id+"not Deleted";
                    }
                    return  status;
                }
            }
            return "dosnt exist";
        }else{
            return "invalid id";
        }
    }
    public String updateById(String id, String status){
        List<User> UserRightNow = userDao.getUserFromData();
        for (User user : UserRightNow) {
            if (user.getUserId().equals(id)) {
                userDao.update(id, status);
            }
        }
        return null;
    }
}
