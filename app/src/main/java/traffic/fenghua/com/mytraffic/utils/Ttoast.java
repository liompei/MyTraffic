package traffic.fenghua.com.mytraffic.utils;

import android.widget.Toast;

import traffic.fenghua.com.mytraffic.MyApplication;

/**
 * Created by BLM on 2016/6/2.
 */
public class Ttoast {

    public static void t(String t) {
        Toast.makeText(MyApplication.instance(), t, Toast.LENGTH_SHORT).show();
    }

}
