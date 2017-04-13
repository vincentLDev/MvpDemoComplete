package com.example.lenovo.mvpdemocomplete.presenter;

import android.os.Handler;

import com.example.lenovo.mvpdemocomplete.model.IUser;
import com.example.lenovo.mvpdemocomplete.model.UserModel;
import com.example.lenovo.mvpdemocomplete.view.ILoginView;




/**
 * Created by Lenovo on 17/4/5.
 */

public class LoginPresenterImpl implements ILoginPresenter {

    /**
     * ILoginView iLoginView，这里LoginPresenterCompl 保留了 ILoginView 的引用，
     * 因此在 LoginPresenterCompl 里就可以直接进行 UI 操作了，而不用在 Activity 里完成
     *
     * 这里使用了 ILoginView 引用，而不是直接使用 Activity，
     * 这样一来，如果在别的 Activity 里也需要用到相同的业务逻辑，就可以直接复用 LoginPresenterCompl 类了
     */
    private ILoginView iLoginView;
    private IUser user;

    private Handler handler;

    public LoginPresenterImpl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        user = new UserModel("mvp","123");

        handler = new Handler();
    }


    @Override
    public void clear() {
        iLoginView.onClearText();

    }

    @Override
    public void doLogin(String name, String passwd) {
        Boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(name, passwd);

        if (code != 0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(result, code);
            }
        }, 5000);

    }

    @Override
    public void setProgressBarVisiblity(int visiblity) {
        iLoginView.onSetProgressBarVisibility(visiblity);
    }

}
