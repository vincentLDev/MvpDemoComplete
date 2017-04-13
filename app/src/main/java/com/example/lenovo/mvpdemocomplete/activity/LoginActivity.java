package com.example.lenovo.mvpdemocomplete.activity;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lenovo.mvpdemocomplete.MainActivity;
import com.example.lenovo.mvpdemocomplete.R;
import com.example.lenovo.mvpdemocomplete.presenter.LoginPresenter;
import com.example.lenovo.mvpdemocomplete.presenter.LoginPresenterImpl;
import com.example.lenovo.mvpdemocomplete.view.LoginView;

/**
 * 并接受并处理来自用户的操作请求，进而作出响应。
 * <p>
 * LoginActivity只做了findView以及setListener的工作，而且包含了一个LoginPresenter接口
 * 所有业务逻辑   都是通过调用LoginPresenter的具体接口来完成：
 * Activity 里只保留对 LoginPresenter 的调用，其它工作全部留到 LoginPresenterImpl中实现
 */
public class LoginActivity extends AppCompatActivity
        implements LoginView, View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private EditText etIpDirect;
    private EditText etUserLAN;
    private EditText etIpRemote;
    private EditText etPwdRemote;
    private EditText etUserRemote;

    private RadioGroup radioGroup;
    private RadioButton rdoDirect;
    private RadioButton rdoLAN;
    private RadioButton rdoRemote;
    private Button btn_login;

//    private ProgressBar progressBar;

    LoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) { // 加载应用的布局和初始化用户界面
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        // find view
        etIpDirect = (EditText) findViewById(R.id.etIpDirect);
        etUserLAN = (EditText) findViewById(R.id.etUserLAN);
        etIpRemote = (EditText) findViewById(R.id.etIpRemote);
        etPwdRemote = (EditText) findViewById(R.id.etPwdRemote);
        etUserRemote = (EditText) findViewById(R.id.etUserRemote);

        radioGroup = (RadioGroup) findViewById(R.id.rgChosePattern);
        rdoDirect = (RadioButton) findViewById(R.id.rdoDirect);
        rdoLAN = (RadioButton) findViewById(R.id.rdoLAN);
        rdoRemote = (RadioButton) findViewById(R.id.rdoRemote);

        btn_login = (Button) findViewById(R.id.btn_login);
//        progressBar = (ProgressBar) findViewById(R.id.progress_login);

        // set listener
        radioGroup.setOnCheckedChangeListener(this);
        btn_login.setOnClickListener(this);

        // init
        loginPresenter = new LoginPresenterImpl(this);

//        loginPresenter.setProgressBarVisiblity(View.INVISIBLE);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
        // 为radioGroup添加监听事件，用来监听组件内部的事件响应
        //在这个函数里面用来改变选择的radioButton的数值，以及与其值相关的任何操作

        switch (checkedId) {
            case R.id.rdoDirect:


                break;
            case R.id.rdoLAN:

                break;
            case R.id.
                    rdoRemote:
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.rdoDirect:
//                loginPresenter.clear();
//                break;
            case R.id.btn_login:
//                loginPresenter.setProgressBarVisiblity(View.VISIBLE);
//                rdoDirect.setEnabled(false);
                String ipDirect = etIpDirect.getText().toString().trim();
                String userLAN = etUserLAN.getText().toString().trim();
                String ipRemote = etIpRemote.getText().toString().trim();
                String userRemote = etUserRemote.getText().toString().trim();
                String pwdRemote = etPwdRemote.getText().toString().trim();


//                loginPresenter.login();
                break;
        }

    }

//    @Override
//    public void onClearText() {
//        editUser.setText("");
//        editPass.setText("");
//    }

    @Override
    public void loginResult(Boolean result, int code) {
//        loginPresenter.setProgressBarVisiblity(View.INVISIBLE);
//        btnClear.setEnabled(true);

        btn_login.setEnabled(true);

        if (result) {
            Toast.makeText(this, "Login Success.", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this, MainActivity.class));

        } else {
            Toast.makeText(this, "Login Failed, code = " + code, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


//
//    @Override
//    public void onSetProgressBarVisibility(int visibility) {
//
//        progressBar.setVisibility(visibility);
//    }

}
