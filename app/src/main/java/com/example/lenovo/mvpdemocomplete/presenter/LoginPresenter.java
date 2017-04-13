package com.example.lenovo.mvpdemocomplete.presenter;

/**
 * Created by Lenovo on 17/4/5.
 */

public interface LoginPresenter {  // 创建 IPresenter 接口，把所有业务逻辑的接口都放在这里

//    void clear();

//    void setProgressBarVisiblity(int visiblity);

    void login(String ip, String name, String passwd);

}
