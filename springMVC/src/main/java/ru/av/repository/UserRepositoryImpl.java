package ru.av.repository;

import org.springframework.stereotype.Repository;
import ru.av.bean.User;

import java.util.*;

/**
 * Created by Полина on 22.09.2016.
 */
@Repository
public class UserRepositoryImpl implements UserRepository{

    private Long userIdSequence = 0L;
    private Map<Long, User> userMap;

    public UserRepositoryImpl() {
        userMap = new HashMap<>();

        User user = new User();
        user.setId(userIdSequence++);
        user.setEmail("a@b.com");
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setLogin("ivan");
        user.setBirthDay(new Date());
        userMap.put(user.getId(), user);

        user = new User();
        user.setId(userIdSequence++);
        user.setEmail("a@b.com");
        user.setFirstName("Petr");
        user.setLastName("Pertov");
        user.setLogin("petr");
        user.setBirthDay(new Date());
        userMap.put(user.getId(), user);

        user = new User();
        user.setId(userIdSequence++);
        user.setEmail("a@b.com");
        user.setFirstName("Vasili");
        user.setLastName("Vasiliev");
        user.setLogin("vasili");
        user.setBirthDay(new Date());
        userMap.put(user.getId(), user);
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
