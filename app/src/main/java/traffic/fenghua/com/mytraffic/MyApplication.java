package traffic.fenghua.com.mytraffic;

import android.app.Application;


import traffic.fenghua.com.mytraffic.utils.CrashHandler;

/**
 * Created by BLM on 2016/5/30.
 */
public class MyApplication extends Application {

    public static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        // 异常处理，不需要处理时注释掉这两句即可！
        CrashHandler crashHandler = CrashHandler.getInstance();
        // 注册crashHandler
        crashHandler.init(getApplicationContext());
    }

    /**
     * 单例
     *
     * @return MyApplication
     */
    public static MyApplication instance() {
        return instance;
    }

}
