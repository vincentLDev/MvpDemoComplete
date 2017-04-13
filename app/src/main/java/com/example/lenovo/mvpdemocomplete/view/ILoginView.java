package com.example.lenovo.mvpdemocomplete.view;

/**
 * Created by Lenovo on 17/4/5.
 */

public interface ILoginView { // 创建 IView 接口，把所有视图逻辑的接口都放在这里

    void onClearText();

    void onLoginResult(Boolean result, int code);

    void onSetProgressBarVisibility(int visibility);
}
