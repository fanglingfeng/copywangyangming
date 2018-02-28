package webhall.tyky.com.wangyangming;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;

import net.liang.appbaselibrary.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import webhall.tyky.com.wangyangming.constants.AppKey;
import webhall.tyky.com.wangyangming.mvp.BaseMainActivity;
import webhall.tyky.com.wangyangming.mvp.home.HomeFragment;
import webhall.tyky.com.wangyangming.mvp.shufang.ShufangFragment;
import webhall.tyky.com.wangyangming.mvp.wode.MainTab_My;
import zhy.com.highlight.HighLight;

public class MainActivity extends BaseMainActivity {

    private String[] imageTags;
    private HighLight mHightLight;
    private int currentTab = 0;//当前tab页
    @Override
    public void initTabs() {
        super.initTabs();
        //获取跳转type,指定当前tab
        currentTab = getIntent().getIntExtra(AppKey.INTENT_KEY,0);
        tabViewpager.setCurrentItem(currentTab);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        currentTab = intent.getIntExtra(AppKey.INTENT_KEY,0);
        tabViewpager.setCurrentItem(currentTab);
    }
    @Override
    protected List<Fragment> getFragments() {
        List<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new ShufangFragment());
        list.add(new MainTab_My());
        list.add(new MainTab_My());

        return list;
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    protected String[] getTabNames() {
        String mTitles[] = getResources().getStringArray(R.array.main_tab_arrays);
        return mTitles;
    }

    @Override
    protected String[] getImgTagRes() {
        if(imageTags == null) {
            imageTags = new String[]{"main_tab_5","main_tab_2","main_tab_3","main_tab_1","main_tab_4"};
        }
        return imageTags;
    }

    @Override
    protected int[] getTabImgRes() {
        int mImages[] = {
                R.drawable.main_tab_5,
                R.drawable.main_tab_5,
                R.drawable.main_tab_5,
                R.drawable.main_tab_5,
                };

        return mImages;
    }

    @Override
    public void initRecyclerView() {

    }

    @Override
    public void showNetworkFail() {

    }

    @Override
    public void showNetworkFail(String err) {

    }

    @Override
    public void showToast(String toast) {
        ToastUtils.showToast(toast);
    }

    /*    @Override
        protected int getLayoutId() {
            return R.layout.activity_main;
        }*/
    public void clickKnown(View view) {
//        if (mHightLight.isShowing() && mHightLight.isNext())//如果开启next模式
//        {
//            mHightLight.next();
//        } else {
//            remove(null);
//        }
    }

    public void remove(View view) {
//        mHightLight.remove();
    }

}
