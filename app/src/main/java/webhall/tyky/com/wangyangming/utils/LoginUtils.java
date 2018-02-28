package webhall.tyky.com.wangyangming.utils;

import android.app.Activity;

import net.liang.appbaselibrary.AppManager;

import webhall.tyky.com.wangyangming.data.AccountHelper;

/**
 * Created by TYKY001 on 2017/9/2.
 */

public class LoginUtils {
    public static void startLoginActivity() {
        AppManager.getAppManager().currentActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AccountHelper.logout();
//                EventBus.getDefault().post(BusConstant.LOGIN_OUT);
            }
        });
        Activity activity = AppManager.getAppManager().currentActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//                    builder.setIcon(R.mipmap.ic_launcher)
//                            .setTitle(R.string.app_name)
//                            .setMessage("登录超时，请重新登录").setPositiveButton("去登录", new DialogInterface.OnClickListener() {
//
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Intent intent = new Intent();
//                            intent.setClass(activity, LoginActivity.class);
//                            activity.startActivity(intent);
//                            dialog.dismiss();
//                            if (!isMainActivity(activity)) {
//                                activity.finish();
//                            }
//                        }
//                    });
//                    //点击返回按钮取消dialog同时直接关闭当前activity
//                    builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
//                        @Override
//                        public void onCancel(DialogInterface dialog) {
//                            if (!isMainActivity(activity)) {
//                                activity.finish();
//                            }
//                        }
//                    });
//                    AlertDialog dialog = builder.create();
//                    //点击dialog之外的区域禁止取消dialog
//                    dialog.setCanceledOnTouchOutside(false);
//                    dialog.show();
                }
            });
        }
    }

    public static boolean isMainActivity(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (localClassName.contains("com.tyky.tykywebhall.mvp.main.MainActivity")) {
            return true;
        }else {
            return false;
        }
    }
}
