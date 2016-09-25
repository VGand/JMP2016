package ru.av.bean;

/**
 * Created by Полина on 24.09.2016.
 */
public class UserAuthorizationInfo {

    private String login;
    private String password;
    private Role userRole;

    public UserAuthorizationInfo(String login, String password, Role userRole) {
        this.login = login;
        this.password = password;
        this.userRole = userRole;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Role getUserRole() {
        return userRole;
    }
}
