package com.example.lenovo.mvpdemocomplete.model;

/**
 * Created by Lenovo on 17/4/5.
 */

public class UserModel implements IUser {

    String name;
    String passwd;

    public UserModel(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
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
    public int checkUserValidity(String name, String password) {

        if (name == null || passwd == null || !name.equals(getName()) || !passwd.equals(getPasswd())) {
            return -1;
        }

        return 0;
    }
}
