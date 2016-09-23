package ru.av.utils;

import ru.av.bean.User;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Andrey_Vaganov on 9/23/2016.
 */
public class UserFilterUtils {

    public static final List<User> filterUserBySearchString(List<User> userList, String searchString) {
        Iterator<User> userIterator = userList.iterator();

        while(userIterator.hasNext()) {
            User user = userIterator.next();
            if (user.getLogin() != null && user.getLogin().contains(searchString)) {
                continue;
            } else if (user.getEmail() != null && user.getEmail().contains(searchString)) {
                continue;
            } else if (user.getFirstName() != null && user.getFirstName().contains(searchString)) {
                continue;
            } else if (user.getLastName() != null && user.getLastName().contains(searchString)) {
                continue;
            } else if (user.getBirthDay() != null) {
                SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
                String strDate = fmt.format(user.getBirthDay());
                if (strDate.contains(searchString)) {
                    continue;
                }
            }

            userIterator.remove();
        }

        return userList;
    }
}
