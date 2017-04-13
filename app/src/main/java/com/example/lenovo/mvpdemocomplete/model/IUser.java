package com.example.lenovo.mvpdemocomplete.model;

/**
 * Created by Lenovo on 17/4/5.
 */

public interface IUser {
    String getName();

    String getPasswd();

    int checkUserValidity(String name, String password);
}
