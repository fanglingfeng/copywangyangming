package webhall.tyky.com.wangyangming.mvp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.socks.library.KLog;

import webhall.tyky.com.wangyangming.R;
import webhall.tyky.com.wangyangming.mvp.maintoolbar.MainToolbarContract;
import webhall.tyky.com.wangyangming.mvp.maintoolbar.MainToolbarPresenter;
import webhall.tyky.com.wangyangming.mvp.maintoolbar.OnMainToolbarListener;


/**
 * Created by Liang on 2017/4/11.
 */
@CoordinatorLayout.DefaultBehavior(MainToolbarBehavior.class)
public class MainToolbar extends FrameLayout implements View.OnClickListener ,MainToolbarContract.View {

    private TextView tv_city;
    private OnMainToolbarListener listener;
    private MainToolbarContract.Presenter presenter;
    private Activity mActivity;
    private TextView title;
    boolean isFirst = true;
    private ImageView moreImg;
    public MainToolbar(@NonNull Context context) {
        super(context);
        init(context);
    }

    public MainToolbar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MainToolbar(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (isFirst&&android.os.Build.VERSION.SDK_INT>=19&&findViewById(R.id.toolbar).getBackground().getAlpha()>0) {
            KLog.d(findViewById(R.id.toolbar).getBackground().getAlpha());
            findViewById(R.id.toolbar).getBackground().setAlpha(0);
//            findViewById(R.id.appbar).getBackground().setAlpha(0);
            isFirst = false;
        }
        super.onLayout(changed, left, top, right, bottom);
    }

    void init(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.toolbar_main, this);
        presenter = new MainToolbarPresenter(this);
        view.findViewById(R.id.toolbar).getBackground().setAlpha(0);
        if (view.isInEditMode()) {
            return;
        }
//        tv_city = (TextView) view.findViewById(R.id.city_tv);
//        view.findViewById(R.id.city).setOnClickListener(this);
//        view.findViewById(R.id.search).setOnClickListener(this);
//        view.findViewById(R.id.more_img).setOnClickListener(this);
        title = (TextView) view.findViewById(R.id.title);
//        tv_city.setText(AppConfig.AREANAME);
//        moreImg = (ImageView) view.findViewById(R.id.more_img);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.city:
//                if (listener !=null){
//                    listener.onCityClick();
//                }
//                break;
//
//            case R.id.search:
//                Intent intent = new Intent(getContext(), ItemSearchActivity.class);
//                getContext().startActivity(intent);
//                break;
//
//            case R.id.more_img:
//                if (popupUtils != null)
//                    showPopupMore(v);
//                break;
        }
    }

    private void showPopupMore(View view) {
        RotateAnimation rotateAnimation;
        rotateAnimation = new RotateAnimation(0.0f, 45f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(200);
        rotateAnimation.setFillAfter(true);
        moreImg.startAnimation(rotateAnimation);

        WindowManager.LayoutParams params = mActivity.getWindow().getAttributes();
        params.alpha = 0.7f;
        mActivity.getWindow().setAttributes(params);
//        popupUtils.showPopupWindow_more(view, v -> {
//            popupUtils.dismissPopupWindow();
//            switch (v.getId()) {
//                case R.id.more_scan_layout://扫描
//                    presenter.checkCameraPermissions();
//                    break;
//                case R.id.app_profile://体系简介
//                    getContext().startActivity(new Intent(getContext(), ProfileActivity.class));
//                    break;
//                case R.id.app_start:
//                    Intent intent_start = new Intent(getContext(), AppStart.class);
//                    getContext().startActivity(intent_start);
//                    break;
//                case R.id.app_common_service://公共服务
//                    Intent intent = new Intent(getContext(),MainActivity.class);
//                    intent.putExtra(AppKey.INTENT_KEY,2);
//                    getContext().startActivity(intent);
//                    break;
            }

    /**
     * 弹出手动设置权限对话框
     *
     * @param permissionType
     */
    @Override
    public void showSetPermissionDialog(String permissionType) {

    }

    /**
     * 打开扫描界面
     */
    @Override
    public void startScanActivity() {

    }

    /**
     * 设置城市
     *
     * @param city
     */
    @Override
    public void setCity(String city) {

    }

    /**
     * 设置标题
     *
     * @param title
     */
    @Override
    public void setTitle(String title) {

    }

    /**
     * 添加回调方法
     *
     * @param listener
     */
    @Override
    public void addOnMainToolbarListener(OnMainToolbarListener listener) {

    }

    /**
     * 设置Activity
     *
     * @param mActivity
     */
    @Override
    public void setActivity(Activity mActivity) {

    }
//        }, () -> {
//            params.alpha = 1f;
//            mActivity.getWindow().setAttributes(params);
//
//
//            //顶部more按钮动画
//            RotateAnimation rotateAnimation1;
//            rotateAnimation1 = new RotateAnimation(45f, 0.0f,
//                    RotateAnimation.RELATIVE_TO_SELF, 0.5f,
//                    RotateAnimation.RELATIVE_TO_SELF, 0.5f);
//
//            rotateAnimation1.setDuration(200);
//            rotateAnimation1.setFillAfter(true);
//            moreImg.startAnimation(rotateAnimation1);
//        }, true, false, true, true,true);
//    }
//    @Override
//    public void addOnMainToolbarListener(OnMainToolbarListener listener) {
//        this.listener = listener;
//    }
//
//    @Override
//    public void setActivity(Activity mActivity) {
//        this.mActivity = mActivity;
//        popupUtils = new PopupUtils(mActivity);
//    }
//
//    @Override
//    public void showSetPermissionDialog(String permissionType) {
//        new MaterialDialog.Builder(getContext())
//                .title("帮助")
//                .content( "当前应用缺少" + permissionType + "权限。\n请点击“设置”-“权限”-打开所需权限。\n最后点击两次后退按钮即可返回。")
//                .positiveText("确定")
//                .negativeText("取消")
//                .cancelable(false)
//                .onPositive((dialog, which) -> {
//                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//                    intent.setData(Uri.parse("package:" + getPackageName()));
//                    getContext().startActivity(intent);
//                })
//                .show();
//    }
//
//    @Override
//    public void startScanActivity() {
//        if (listener != null){
//            listener.onStartScan();
//        }
//    }
//
//    @Override
//    public void setCity(String city) {
//        if (tv_city != null){
//            tv_city.setText(city);
//        }
//    }
//    @Override
//    public void setTitle(String title) {
//        if (title != null)
//            this.title.setText(title);
//    }
//
//    public void updateWeather() {
//
//    }
}
