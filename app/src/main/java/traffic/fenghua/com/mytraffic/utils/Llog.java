package traffic.fenghua.com.mytraffic.utils;

import android.util.Log;

/**
 * Created by BLM on 2016/6/1.
 */
public class Llog {

    //error 错误 红色
    public static void e(String e) {
        Log.e("****************", e);
    }

    //debug 调试 蓝色
    public static void d(String d) {
        Log.d("****************", d);
    }

    //information 提示 绿色
    public static void i(String i) {
        Log.i("****************", i);
    }

    //warning 警告 橙色
    public static void w(String w) {
        Log.w("****************", w);
    }

    //verbose 啰嗦 灰色
    public static void v(String v) {
        Log.v("****************", v);
    }

}
