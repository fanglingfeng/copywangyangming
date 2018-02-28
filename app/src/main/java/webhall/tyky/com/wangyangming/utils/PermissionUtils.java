package webhall.tyky.com.wangyangming.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

/**
 * Created by xieguangwei on 2016/12/13.
 * 权限申请管理工具类（主要针对android6.0及以上系统）
 */

public class PermissionUtils {
    public static final int REQUEST_EXTERNAL_STORAGE = 1;//申请读写权限
    public static final int REQUEST_CAMARA = 2;//申请打开相机权限
    public static final int REQUEST_CALL_PHONE = 3;//申请拨打电话权限
    public static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };//读取sd卡权限

    public static String[] PERMISSIONS_CAMARA = {
            Manifest.permission.CAMERA
    };//打开相机权限

    public static String[] PERMISSIONS_CALL_PHONE = {
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.CALL_PHONE
    };//拨打电话权限

    /**
     * 检测申请读写权限方法
     * @param activity
     */
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        /**
         * 23及以上系统版本
         */
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(
                        activity,
                        PERMISSIONS_STORAGE,
                        REQUEST_EXTERNAL_STORAGE
                );
            }
        }
    }

    /**
     * 检测申请相机权限
     * @param activity
     */
    public static void verifyCameraPermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.CAMERA);

        /**
         * 23及以上系统版本
         */
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(
                        activity,
                        PERMISSIONS_CAMARA,
                        REQUEST_CAMARA
                );
            }
        }
    }

    /**
     * 检测并申请拨打电话权限
     * @param activity
     */
    public static void verifyCallPhonePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE);

        /**
         * 23及以上系统版本
         */
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(
                        activity,
                        PERMISSIONS_CALL_PHONE,
                        REQUEST_CALL_PHONE
                );
            }
        }
    }

    // 含有全部的权限
    public static boolean hasAllPermissionsGranted(@NonNull int[] grantResults) {
        for (int grantResult : grantResults) {
            if (grantResult == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasSpecifiedPermission(@NonNull int permission){
        return permission == PackageManager.PERMISSION_GRANTED;
    }
}
