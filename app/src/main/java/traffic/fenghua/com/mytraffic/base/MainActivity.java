package traffic.fenghua.com.mytraffic.base;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import traffic.fenghua.com.mytraffic.R;
import traffic.fenghua.com.mytraffic.fragment.Fragment_1;
import traffic.fenghua.com.mytraffic.fragment.Fragment_2;
import traffic.fenghua.com.mytraffic.fragment.Fragment_3;
import traffic.fenghua.com.mytraffic.entry.MainTabs;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.linear)
    LinearLayout linear;  //总布局
    @BindView(R.id.tooltext)
    TextView tooltext;  //toolbar
    @BindView(R.id.mainContent)
    FrameLayout mainContent;  //填充内容
    @BindView(R.id.tabHost)
    FragmentTabHost fragmentTabHost;  //下方标签
    @BindView(R.id.tabContent)
    FrameLayout tabContent;  //下方标签内容

    private LayoutInflater inflater;  //用于装载view
    private List<MainTabs> mTabs = new ArrayList<>(3);  //用于储存每个标签内容

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initTabs();
    }

    private void initTabs() {
        //Tab对象
        MainTabs tabs1 = new MainTabs("主页", R.drawable.selector_fragment_1, Fragment_1.class);
        MainTabs tabs2 = new MainTabs("消息", R.drawable.selector_fragment_2, Fragment_2.class);
        MainTabs tabs3 = new MainTabs("我的", R.drawable.selector_fragment_3, Fragment_3.class);

        mTabs.add(tabs1);
        mTabs.add(tabs2);
        mTabs.add(tabs3);

        inflater = LayoutInflater.from(this);
        fragmentTabHost.setup(this, getSupportFragmentManager(), R.id.mainContent);  //表示主内容的视图为定义的fragment内视图

        //取出每一个,进行设置
        for (MainTabs mainTabs : mTabs) {
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(mainTabs.getTitle());
            tabSpec.setIndicator(buildTabs(mainTabs));
            fragmentTabHost.addTab(tabSpec, mainTabs.getFragment(), null);
        }
//        fragmentTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);  //去掉分割线 ?
        fragmentTabHost.setCurrentTab(0);  //默认选择第一个

    }

    //传入一个tab对象,返回一个view
    private View buildTabs(MainTabs mainTabs) {
        View view = inflater.inflate(R.layout.tab_indicator, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.tab_icon);
        TextView textView = (TextView) view.findViewById(R.id.tab_text);

        //设置图片和文字
        imageView.setBackgroundResource(mainTabs.getIcon());
        textView.setText(mainTabs.getTitle());
        return view;
    }

}
