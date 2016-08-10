package traffic.fenghua.com.mytraffic.utils;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;

import java.util.ArrayList;
import java.util.List;

import traffic.fenghua.com.mytraffic.MyApplication;
import traffic.fenghua.com.mytraffic.base.MainActivity;

/**
 * Created by BLM on 2016/6/1.
 */
public class Utils {

    /**
     * 实例化 单例 双重锁定
     */
//    private volatile static Utils utils;
//    private Utils() {
//    }
//    public static Utils instance() {
//        if (utils == null) {
//            synchronized (Utils.class) {
//                if (utils == null) {
//                    utils = new Utils();
//                }
//            }
//        }
//        return utils;
//    }

    /**
     * 判断版本,如果API高于23则获取权限
     *
     * @param activity
     */
    public void getPermission(final Activity activity) {

        //判断版本
        if (Build.VERSION.SDK_INT >= 23) {

        }
    }

    /**
     * 获得手机串号
     */
    public static String getPhoneSN(){
        TelephonyManager telephonyManager= (TelephonyManager) MyApplication.instance()
                .getSystemService(Context.TELEPHONY_SERVICE);
        String deviceIMEI=telephonyManager.getDeviceId();
        return deviceIMEI;
    }

}
