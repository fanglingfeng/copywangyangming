package webhall.tyky.com.wangyangming.mvp.maintoolbar;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;

import com.socks.library.KLog;
import com.tbruyelle.rxpermissions2.RxPermissions;

import net.liang.appbaselibrary.utils.ToastUtils;

import io.reactivex.observers.DisposableObserver;
import webhall.tyky.com.wangyangming.AppConfig;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Liang on 2017/4/11.
 */

public class MainToolbarPresenter implements MainToolbarContract.Presenter {

    @NonNull
    private MainToolbarContract.View mView;

    public MainToolbarPresenter(@NonNull MainToolbarContract.View mView) {
        this.mView = checkNotNull(mView);
    }

    @Override
    public void checkCameraPermissions() {
        KLog.e("开始检测是否有打开相机权限...");
        PackageManager pm = AppConfig.getInstance().getPackageManager();
        if (pm.hasSystemFeature(PackageManager.FEATURE_CAMERA)
                && pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT)) {
            RxPermissions.getInstance(AppConfig.getInstance()).request(Manifest.permission.CAMERA)
                    .subscribeWith(new DisposableObserver<Boolean>() {
                        @Override
                        public void onNext(Boolean value) {
                            if (value) {
                                KLog.e("有打开相机权限，开始扫描...");
                                mView.startScanActivity();
                            } else {
                                KLog.e("没有打开相机权限，弹出对话框...");
                                mView.showSetPermissionDialog("拍照");
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            KLog.e("检测相机权限抛异常了：" + e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } else {
            ToastUtils.showToast("没有相机设备！");
        }
    }
}
