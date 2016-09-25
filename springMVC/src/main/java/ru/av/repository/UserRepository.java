package ru.av.repository;

import ru.av.bean.LoginBean;
import ru.av.bean.User;
import ru.av.bean.UserAuthorizationInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Полина on 22.09.2016.
 */
public interface UserRepository {
    Long createUser(User user);

    void updateUser(User user);

    void delete(Long id);

    User getUserById(Long id);

    List<User> getAllUsers();

    UserAuthorizationInfo checkUser(LoginBean loginBean);
}
