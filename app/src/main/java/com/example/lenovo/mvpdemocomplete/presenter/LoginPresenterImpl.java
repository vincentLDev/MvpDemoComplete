package com.example.lenovo.mvpdemocomplete.presenter;

import android.os.Handler;

import com.example.lenovo.mvpdemocomplete.model.IUser;
import com.example.lenovo.mvpdemocomplete.model.UserModel;
import com.example.lenovo.mvpdemocomplete.view.LoginView;


/**
 * Created by Lenovo on 17/4/5.
 */

public class LoginPresenterImpl implements LoginPresenter {

    /**
     * LoginView iLoginView，这里LoginPresenterCompl 保留了 LoginView 的引用，
     * 因此在 LoginPresenterCompl 里就可以直接进行 UI 操作了，而不用在 Activity 里完成
     * <p>
     * 这里使用了 LoginView 引用，而不是直接使用 Activity，
     * 若，在别的 Activity 里也需要用到相同的业务逻辑，就直接复用 LoginPresenterCompl类
     */
    private LoginView iLoginView;
    private IUser user;
    private Handler handler;

    public LoginPresenterImpl(LoginView iLoginView) {
        this.iLoginView = iLoginView;
        user = new UserModel("WS://192.168.16.153:5560", "mvp", "123456");

        handler = new Handler();
    }


//    @Override
//    public void clear() {
//        iLoginView.onClearText();
//
//    }

    @Override
    public void login(String ip, String name, String passwd) {
        Boolean isLoginSuccess = true;


        final int code = user.checkUserValidity(ip, name, passwd);

        if (code != 0)
            isLoginSuccess = false;
        final Boolean result = isLoginSuccess;

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {

                iLoginView.loginResult(result, code);
            }

        }, 3000);

    }

//    @Override
//    public void setProgressBarVisiblity(int visiblity) {
//        iLoginView.onSetProgressBarVisibility(visiblity);
//    }

}
