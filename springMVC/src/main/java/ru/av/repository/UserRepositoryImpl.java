package ru.av.repository;

import org.springframework.stereotype.Repository;
import ru.av.bean.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Полина on 22.09.2016.
 */
@Repository
public class UserRepositoryImpl implements UserRepository{

    private Long userIdSequence = 0L;
    private Map<Long, User> userMap;

    public UserRepositoryImpl() {
        userMap = new HashMap<>();
    }

    public Long createUser(User user) {
        Long id = userIdSequence++;
        user.setId(id);
        userMap.put(id, user);

        return id;
    }

    public void updateUser(User user) {
        userMap.put(user.getId(), user);
    }

    public void delete(Long id) {
        userMap.remove(id);
    }

    public User getUserById(Long id) {
        return userMap.get(id);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

}
