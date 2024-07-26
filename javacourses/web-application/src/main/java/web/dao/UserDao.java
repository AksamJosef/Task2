package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    public static final List<User> users = new ArrayList<>();


    public List<User> addUser(User user) {
        users.add(user);
        return users;
    }
}
