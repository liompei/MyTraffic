package traffic.fenghua.com.mytraffic.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import traffic.fenghua.com.mytraffic.R;

/**
 * Created by BLM on 2016/6/3.
 */
public class Fragment_2 extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_2,container,false);
        return view;
    }
}
