package com.example.lenovo.mvpdemocomplete.view;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lenovo.mvpdemocomplete.HomeActivity;
import com.example.lenovo.mvpdemocomplete.R;
import com.example.lenovo.mvpdemocomplete.presenter.ILoginPresenter;
import com.example.lenovo.mvpdemocomplete.presenter.LoginPresenterImpl;
import com.example.lenovo.mvpdemocomplete.view.ILoginView;

/**
 * 并接受并处理来自用户的操作请求，进而作出响应。
 * <p>
 * LoginActivity只做了findView以及setListener的工作，而且包含了一个ILoginPresenter接口
 * 所有业务逻辑   都是通过调用ILoginPresenter的具体接口来完成：Activity 里只保留对 IPresenter 的调用，其它工作全部留到 PresenterImpl 中实现
 *
 */
public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    private EditText editUser;
    private EditText editPass;
    private Button btnLogin;
    private Button btnClear;
    private ProgressBar progressBar;

    ILoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) { // 加载应用的布局和初始化用户界面
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {

        // find view
        editUser = (EditText) findViewById(R.id.et_login_username);
        editPass = (EditText) findViewById(R.id.et_login_password);
        btnLogin = (Button) findViewById(R.id.btn_login_login);
        btnClear = (Button) findViewById(R.id.btn_login_clear);
        progressBar = (ProgressBar) findViewById(R.id.progress_login);

        // set listener
        btnLogin.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        // init
        loginPresenter = new LoginPresenterImpl(this);

        loginPresenter.setProgressBarVisiblity(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login_clear:
                loginPresenter.clear();

                break;
            case R.id.btn_login_login:
                loginPresenter.setProgressBarVisiblity(View.VISIBLE);
                btnLogin.setEnabled(false);
                btnClear.setEnabled(false);

                loginPresenter.doLogin(editUser.getText().toString(), editPass.getText().toString());
                break;
        }
    }

    @Override
    public void onClearText() {
        editUser.setText("");
        editPass.setText("");
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        loginPresenter.setProgressBarVisiblity(View.INVISIBLE);
        btnLogin.setEnabled(true);
        btnClear.setEnabled(true);

        if (result) {
            Toast.makeText(this, "Login Success.", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this, HomeActivity.class));

        } else {
            Toast.makeText(this, "Login Failed, code = " + code, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {

        progressBar.setVisibility(visibility);
    }

}
