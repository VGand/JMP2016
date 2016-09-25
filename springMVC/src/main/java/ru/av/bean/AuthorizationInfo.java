package ru.av.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import ru.av.bean.UserAuthorizationInfo;

/**
 * Created by Полина on 24.09.2016.
 */
public class AuthorizationInfo {

    private UserAuthorizationInfo userAuthorizationInfo;

    public UserAuthorizationInfo getUserAuthorizationInfo() {
        return userAuthorizationInfo;
    }

    public void setUserAuthorizationInfo(UserAuthorizationInfo userAuthorizationInfo) {
        this.userAuthorizationInfo = userAuthorizationInfo;
    }
}
