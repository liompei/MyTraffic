package traffic.fenghua.com.mytraffic.entry;

/**
 * 主界面
 * Created by BLM on 2016/6/2.
 */
public class MainTabs {
    private String title;
    private int icon;
    private Class fragment;

    public MainTabs(String title, int icon, Class fragment) {
        this.title = title;
        this.icon = icon;
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }
}
