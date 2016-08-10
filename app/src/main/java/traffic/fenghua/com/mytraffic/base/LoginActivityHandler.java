package traffic.fenghua.com.mytraffic.base;

import android.app.ProgressDialog;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import traffic.fenghua.com.mytraffic.Constants;
import traffic.fenghua.com.mytraffic.MyApplication;
import traffic.fenghua.com.mytraffic.R;
import traffic.fenghua.com.mytraffic.utils.Llog;
import traffic.fenghua.com.mytraffic.utils.PreferencesUtils;
import traffic.fenghua.com.mytraffic.utils.Ttoast;

/**
 * Created by BLM on 2016/6/3.
 */
public class LoginActivityHandler {

    private LoginActivity loginActivity;

    public LoginActivityHandler(LoginActivity activity) {
        loginActivity = activity;
    }

    /**
     * 提交登录信息进行登录
     */
    public void commit(final String email, final String password, final String IMEI, final ProgressDialog progressDialog) {
        RequestQueue requestQueue = Volley.newRequestQueue(MyApplication.instance());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.HOST + MyApplication.instance().getString(R.string.mobileLogin),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        loginActivity.loginButtontrue();
                        Llog.d("登录查询成功");
                        if (response == null) {
                            Ttoast.t("服务器错误");
                            return;
                        }
                        parseJson(response);  //解析获取的数据
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Llog.e(error + "");
                Ttoast.t("登录错误 " + error);
                loginActivity.onLoginFailed();
                progressDialog.dismiss();
                loginActivity.loginButtontrue();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("msgno", "001001");
                map.put("username", email);
                map.put("password", password);
                map.put("imei", IMEI);
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }


    private void parseJson(String response) {
        Llog.d(response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            int code = Integer.parseInt(PreferencesUtils.getJsonString(jsonObject, "code"));
            String msg = PreferencesUtils.getJsonString(jsonObject, "msg");
            if (code == 0) {
                Llog.d("msg: " + msg);
                loginActivity.onLoginSuccess();
            } else if (code == 1) {
                Llog.d("msg: " + msg);
                Ttoast.t("登陆成功");
                String data = PreferencesUtils.getJsonString(jsonObject, "data");
                Llog.d(data);
                JSONObject jsonObject1 = new JSONObject(data);
                String xtyh = PreferencesUtils.getJsonString(jsonObject1, "xtyh");
                JSONObject jsonObject2 = new JSONObject(xtyh);

                PreferencesUtils.putSharePre("id",PreferencesUtils.getJsonString(jsonObject2,"id"));
                PreferencesUtils.putSharePre("miaoshu",PreferencesUtils.getJsonString(jsonObject2,"miaoshu"));
                PreferencesUtils.putSharePre("nickName",PreferencesUtils.getJsonString(jsonObject2,"nickName"));
                PreferencesUtils.putSharePre("username",PreferencesUtils.getJsonString(jsonObject2,"username"));
                PreferencesUtils.putSharePre("password",PreferencesUtils.getJsonString(jsonObject2,"password"));
                PreferencesUtils.putSharePre("token",PreferencesUtils.getJsonString(jsonObject2,"token"));
                PreferencesUtils.putSharePre("zhuangtai",PreferencesUtils.getJsonString(jsonObject2,"zhaungtai"));
                loginActivity.onLoginSuccess();
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
