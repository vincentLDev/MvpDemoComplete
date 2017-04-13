package com.example.lenovo.mvpdemocomplete.presenter;

/**
 * Created by Lenovo on 17/4/5.
 */

public interface ILoginPresenter {  // 创建 IPresenter 接口，把所有业务逻辑的接口都放在这里

    void clear();

    void doLogin(String name, String passwd);

    void setProgressBarVisiblity(int visiblity);
}
