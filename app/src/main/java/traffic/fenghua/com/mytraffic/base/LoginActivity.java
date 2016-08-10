package traffic.fenghua.com.mytraffic.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import traffic.fenghua.com.mytraffic.R;
import traffic.fenghua.com.mytraffic.utils.Llog;
import traffic.fenghua.com.mytraffic.utils.Ttoast;
import traffic.fenghua.com.mytraffic.utils.Utils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.input_email)
    EditText _emailText;
    @BindView(R.id.input_password)
    EditText _passwordText;
    @BindView(R.id.btn_login)
    Button _loginButton;
    @BindView(R.id.link_signup)
    TextView _signupLink;
    @BindView(R.id.imei)
    TextView imei;

    private LoginActivityHandler loginActivityHandler;  //用于网络操作


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        imei.setText(Utils.getPhoneSN());
        _loginButton.setOnClickListener(this);
        _signupLink.setOnClickListener(this);
        loginActivityHandler = new LoginActivityHandler(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.link_signup:

                break;
        }
    }

    //登录
    private void login() {
        Llog.d("Login");
        if (!validate()) {
            onLoginFailed();
            return;
        }
        _loginButton.setEnabled(false);
        final ProgressDialog progressDialog = new ProgressDialog(this, R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("正在登录...");
        progressDialog.show();

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
//        /**
//         * 模拟
//         */
//        new android.os.Handler().postDelayed(
//                new Runnable() {
//                    @Override
//                    public void run() {
//                        onLoginSuccess();
//                        progressDialog.dismiss();
//                    }
//                }
//        ,3000);
//        loginActivityHandler.commit(email,password, "867979020310733",progressDialog);  //登录->网络操作(账号,密码,IMEI)

        startActivity(new Intent(this,MainActivity.class));

    }


    //验证
    public boolean validate() {
        boolean valid = true;
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("这不是一个Email地址");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 15) {
            _passwordText.setError("长度要在4-15之间");
            valid = false;
        } else {
            _passwordText.setError(null);
        }
        return valid;
    }
    //监听后退键
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    //Button
    public void loginButtontrue(){
        _loginButton.setEnabled(true);
    }

    //登录成功
    public void onLoginSuccess() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    //登录失败
    public void onLoginFailed() {
        Ttoast.t("登录失败");
    }

}
