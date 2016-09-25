package ru.av.bean;

/**
 * Created by Полина on 24.09.2016.
 */
public enum Role {

    ADMIN("admin"),
    USER("user");

    private String roleSysName;

    Role(String roleSysName) {
        this.roleSysName = roleSysName;
    }
}
