package traffic.fenghua.com.mytraffic;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import traffic.fenghua.com.mytraffic.base.LoginActivity;
import traffic.fenghua.com.mytraffic.utils.Llog;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Llog.d("aaaaa");
                startActivity(new Intent(MyApplication.instance(), LoginActivity.class));
                finish();
            }
        }, 3000);

    }

}
