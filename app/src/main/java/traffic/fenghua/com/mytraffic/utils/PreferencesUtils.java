package traffic.fenghua.com.mytraffic.utils;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONException;
import org.json.JSONObject;

import traffic.fenghua.com.mytraffic.MyApplication;

/**
 * 介绍: 此类用来缓存用户及数据
 * Created by BLM on 2016/6/3.
 */
public class PreferencesUtils {

    //存数据
    public static void putSharePre(String key, String value) {
        String FILE = "MyTraffic";
        SharedPreferences sharedPreferences = MyApplication.instance().getSharedPreferences(FILE, Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(key, value).commit();
    }

    //取数据
    public static String getSharePreStr(String property) {
        String FILE = "RongDemo";
        SharedPreferences sharedPreferences = MyApplication.instance().getSharedPreferences(FILE, Context.MODE_PRIVATE);
        String str = sharedPreferences.getString(property, null);
        return str;
    }


    //获取json字符串(非集合)中某个字段的值
    public static String getJsonString(JSONObject jsonObject, String property) {
        String data = "";
        try {
            if (!jsonObject.isNull(property)) {
                data = jsonObject.getString(property);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }

}
