package com.example.lenovo.mvpdemocomplete.model;

/**
 * Created by Lenovo on 17/4/5.
 */

public class UserModel implements IUser {

    String ip;
    String name;
    String passwd;

    public UserModel(String ip, String name, String passwd) {
        this.ip = ip;
        this.name = name;
        this.passwd = passwd;
    }

    @Override
    public String getIp() {
        return ip;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPasswd() {
        return passwd;
    }

    @Override
    public int checkUserValidity(String ip, String name, String password) {

        if (ip == null || name == null || passwd == null ||
                !ip.equals(getIp()) || !name.equals(getName()) || !passwd.equals(getPasswd())) {

            return -1;
        }

        return 0;
    }
}
