package traffic.fenghua.com.mytraffic.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import traffic.fenghua.com.mytraffic.MyApplication;
import traffic.fenghua.com.mytraffic.R;

/**
 * Created by BLM on 2016/6/2.
 */
public class Fragment_1 extends Fragment {
    View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_1, container, false);
        ButterKnife.bind(this, view);


        return view;
    }


    @OnClick(R.id.main_one)
    void main_one() {
        Toast.makeText(MyApplication.instance(), "出乘", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.main_two)
    void main_two() {
        Toast.makeText(MyApplication.instance(), "公告", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.main_three)
    void main_three() {
        Toast.makeText(MyApplication.instance(), "情况报告", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.main_four)
    void main_four() {
        Toast.makeText(MyApplication.instance(), "乘务报告", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.main_five)
    void main_five() {
        Toast.makeText(MyApplication.instance(), "干部添乘", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.main_six)
    void main_six() {
        Toast.makeText(MyApplication.instance(), "干部管理", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.main_seven)
    void main_seven() {
        Toast.makeText(MyApplication.instance(), "命令通知", Toast.LENGTH_SHORT).show();
    }


}
