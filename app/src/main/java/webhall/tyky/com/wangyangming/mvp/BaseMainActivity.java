package webhall.tyky.com.wangyangming.mvp;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dino.changeskin.SkinManager;
import com.dino.changeskin.utils.PrefUtils;

import net.liang.appbaselibrary.AppManager;
import net.liang.appbaselibrary.base.BaseAppCompatActivity;
import net.liang.appbaselibrary.base.BaseViewpagerAdapter;
import net.liang.appbaselibrary.base.mvp.MvpPresenter;
import net.liang.appbaselibrary.widget.dialog.DialogHelper;

import java.util.List;

import webhall.tyky.com.wangyangming.R;
import webhall.tyky.com.wangyangming.mvp.maintoolbar.OnMainToolbarListener;
import webhall.tyky.com.wangyangming.utils.DialogUtils;


/**
 * Created by Liang on 2017/4/11.
 */

public abstract class BaseMainActivity extends BaseAppCompatActivity implements MainContract.View {

    protected ViewPager tabViewpager;
    protected TabLayout tabLayout;
    protected DrawerLayout drawerLayout;
//    protected AreaChooseView areaLayout;
    protected MainToolbar mainToolbar;
    protected AppBarLayout appBarLayout;

    protected BaseViewpagerAdapter adapter;

    protected DialogHelper dialogHelper;
    protected MainContract.Presenter presenter;

    protected DialogUtils dialogUtils;

    protected boolean isCancel;

    protected long mExitTime;

    @Override
    public boolean isUseButterKnife() {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    protected MvpPresenter getPresenter() {
        return presenter;
    }

    protected PrefUtils prefUtils;
    private View statusBarView;

    public void init() {
        tabViewpager = (ViewPager) findViewById(R.id.tab_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mainToolbar = (MainToolbar) findViewById(R.id.main_toolbar);
//        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        dialogHelper = new DialogHelper(this);
        dialogUtils = new DialogUtils(this);

        presenter = new MainPresenter(this);
//        presenter.checkVersion();

        //结束启动页
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        initToolbar();
        initArea();

    }

    //mainToolBar 回调
    public void initToolbar() {
        mainToolbar.setActivity(this);
        mainToolbar.addOnMainToolbarListener(new OnMainToolbarListener() {
            @Override
            public void onCityClick() {
//                if (drawerLayout != null) {
//                    drawerLayout.openDrawer(Gravity.LEFT, true);
//                    EventBus.getDefault().post(OPEN_DRAWERLAYOUT);
//                }
            }

            @Override
            public void onStartScan() {
//                Bundle bundle = new Bundle();
//                bundle.putString(AppKey.SCANTITLE, "获取业务流水号");
//                nextActivityForResult(ScanActivity.class, SCANNING, bundle);
            }
        });
        prefUtils = new PrefUtils(BaseMainActivity.this);
//        if (Build.VERSION.SDK_INT < 21) {
//            if ("red".equals(prefUtils.getSuffix())) {
//                appBarLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary_red));
//            } else if ("yellow".equals(prefUtils.getSuffix())) {
//                appBarLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary_yellow));
//            } else {
//                appBarLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//            }
//        }
    }

    //侧栏回调
    public void initArea() {
//        areaLayout.addAreaChooseListener(new OnAreaChooseListener() {
//            @Override
//            public void onCancer() {
//
//            }
//
//            @Override
//            public void onStart() {
//
//            }
//
//            @Override
//            public void onBack() {
//
//            }
//
//            @Override
//            public void onResult(String areaID, String areaName) {
//                drawerLayout.closeDrawers();
//                mainToolbar.setCity(areaName);
//                showToast(areaName);
//                mainToolbar.updateWeather();
//            }
//        });
    }



    public void initTabs() {
        /** 解决 fragment 嵌套切换问题*/
        adapter = new BaseViewpagerAdapter(getSupportFragmentManager(), getFragments());
        tabViewpager.setAdapter(adapter);
        tabViewpager.setOffscreenPageLimit(4);//设置缓存页
        tabLayout.setupWithViewPager(tabViewpager);

        //设置自定义标题
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            //获得到对应位置的Tab
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            //设置自定义的标题
            tab.setCustomView(getTabView(i));
        }
    }

    private View getTabView(int position) {
        View view = LayoutInflater.from(this).inflate(R.layout.main_item_tab, null);
        ImageView iv_tab = (ImageView) view.findViewById(R.id.image);
        TextView tv_tab = (TextView) view.findViewById(R.id.title);
        iv_tab.setImageResource(getTabImgRes()[position]);
        //给imageview换肤，要加tag,规则是skin:+资源名+:src
        if (getImgTagRes() != null) {
            iv_tab.setTag("skin:" + getImgTagRes()[position] + ":src");
        }
        tv_tab.setText(getTabNames()[position]);
        //动态添加的view要injectskin，如adapter中要injectskin
        SkinManager.getInstance().injectSkin(view);
        return view;
    }

//    @Override
//    public void downloadError() {
//        dialogUtils.dismissDownloadProgressDialog();
//    }
//
//    @Override
//    public void startBrowser(String url) {
//        Bundle bundle = new Bundle();
//        bundle.putString(AppKey.url, url);
//        bundle.putString(AppKey.title, "浏览器");
//        nextActivity(OnlineApplyWebActivity_Baoan.class, bundle);
//    }

//    //进入事项导办
//    @Override
//    public void gotoPermGuide(Permission permission) {
//        SxdbWebActivity.startInstance(this, 1, permission);
//
//    }
//
//    @Override
//    public void gotoApplyPermGuidActivity(Permission permission) {
//        SxdbWebActivity.startInstance(this,1,permission);
//    }

//    @Override
//    public void startDaobanBrowser(TykyAppQrCodeBean tykyAppQrCodeBean) {
//        Bundle bundle = new Bundle();
//        String scanMode = tykyAppQrCodeBean.getScanMode();
//        String type = tykyAppQrCodeBean.getType();
//        String sxid = tykyAppQrCodeBean.getSxid();
//        if (!TextUtils.isEmpty(scanMode) && TextUtils.equals(scanMode, "1")) {
////            String url = "";
////            bundle.putString(AppKey.url, url);
////            bundle.putString(AppKey.title, "浏览器");
//////            nextActivity(OnlineApplyWebActivity_Baoan.class, bundle);
////            nextActivity(NavigatingActivity.class);
//            startActivity(new Intent(BaseMainActivity.this, SxdbWebActivity.class));
//        }
//
//    }


//    @Override
//    public void showSetPermissionDialog(String permissionType) {
//        dialogHelper.alert("帮助", "当前应用缺少" + permissionType + "权限。\n请点击“设置”-“权限”-打开所需权限。\n最后点击两次后退按钮即可返回。", "设置", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//                intent.setData(Uri.parse("package:" + getPackageName()));
//                startActivity(intent);
//            }
//        }, "取消", (dialog, which) -> {
//        });
//    }

//    @Override
//    public void startSearchScheduleActivity(Bundle bundle) {
//        nextActivity(SearchScheduleActivity.class, bundle);
//    }
//
//    @Override
//    public void startAuthLoginActivity(String result) {
//        Bundle bundle = new Bundle();
//        bundle.putString(AppKey.RESULT, result);
//        nextActivity(AuthLoginActivity.class, bundle);
//    }
//
//    @Override
//    public void showDownloadDialog(String downloadDesc) {
//        dialogUtils.showDownloadDialog(downloadDesc, v -> {
//            presenter.checkExternalStoragePermission();
//            dialogUtils.dismissDownloadDialog();
//        }, v -> dialogUtils.dismissDownloadDialog());
//    }

//    @Override
//    public void showDownloadProgressDialog() {
//        dialogUtils.showDownloadProgressDialog(v -> {
//            isCancel = true;
//            dialogUtils.dismissDownloadProgressDialog();
//            presenter.disposeDownloadProcess();
//        }, (dialog, which) -> {
//            isCancel = true;
//            dialogUtils.dismissDownloadProgressDialog();
//            presenter.disposeDownloadProcess();
//        });
//
//        presenter.startDownload(this, isCancel);
//
//    }

//    @Override
//    public void setDownloadProgress(final int progress) {
//        KLog.e("在主界面中展示进度：" + progress);
//        runOnUiThread(() -> dialogUtils.setDownloadProgress(progress));
//    }
//
//    @Override
//    public void startInstallApk(File file) {
//        dialogUtils.dismissDownloadProgressDialog();
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//            Uri contentUri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".fileProvider", file);
//            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
//        } else {
//            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        }
//        startActivity(intent);
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (resultCode == RESULT_OK) {
//            switch (requestCode) {
//                case SCANNING:
//                    //处理扫描结果,跳转到查询页面
//                    if (data == null) {
//                        break;
//                    }
//                    presenter.checkScanResultData(data);
//                    break;
//            }
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }
//
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onEventMainThread(BusConstant busConstant) {
//        int position = getFragments().size() - 2;
//        if (position >= 0) {
//            switch (busConstant) {
//                case SHOW_READ_DOT:
//                    View view1 = tabLayout.getTabAt(position).getCustomView();
//                    view1.findViewById(R.id.red_dot).setVisibility(View.VISIBLE);
//                    break;
//
//                case NOT_SHOW_READ_DOT:
//                    View view2 = tabLayout.getTabAt(position).getCustomView();
//                    view2.findViewById(R.id.red_dot).setVisibility(View.GONE);
//                    break;
//                case UPDATE_WEATHER:
//                    mainToolbar.updateWeather();
//                    break;
//            }
//        }
//        switch (busConstant) {
//            case CLOSE_DRAWERLAYOUT:
//                drawerLayout.closeDrawers();
//                mainToolbar.setCity(AppConfig.AREANAME);
//                showToast(AppConfig.AREANAME);
//                break;
//
//
//        }
//    }

    // 监听手机上的BACK键
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 判断两次点击的时间间隔（默认设置为2秒）
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                //finish();
                //System.exit(0);
                //super.onBackPressed();
                AppManager.getAppManager().AppExit();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected abstract List<Fragment> getFragments();

    protected abstract String[] getTabNames();

    protected abstract int[] getTabImgRes();

    protected String[] getImgTagRes() {
        return null;
    }
}