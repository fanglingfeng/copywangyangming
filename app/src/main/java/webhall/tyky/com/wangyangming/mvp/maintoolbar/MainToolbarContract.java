package webhall.tyky.com.wangyangming.mvp.maintoolbar;

import android.app.Activity;

/**
 * Created by Liang on 2017/4/11.
 */

public interface MainToolbarContract {
    interface View{
        /**
         * 弹出手动设置权限对话框
         */
        void showSetPermissionDialog(String permissionType);

        /**
         * 打开扫描界面
         */
        void startScanActivity();

        /**
         * 设置城市
         * */
        void setCity(String city);
        /**
         * 设置标题
         * */
        void setTitle(String title);

        /**
        * 添加回调方法
        * */
        void addOnMainToolbarListener(OnMainToolbarListener listener);

        /**
         * 设置Activity
         * */
        void setActivity(Activity mActivity);
    }

    interface Presenter{
        /**
         * 检测相机权限
         */
        void checkCameraPermissions();
    }
}
