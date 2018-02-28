package webhall.tyky.com.wangyangming.utils;

import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;

import webhall.tyky.com.wangyangming.AppConfig;


/**
 * Created by hugo on 2016/2/19 0019.
 *
 * 设置相关 包括 sp 的写入
 */
public class SharedPreferenceUtil {

    public static final String CITY_NAME = "城市";//选择城市
    public static final String HOUR = "current_hour";//当前小时

    public static final String CHANGE_ICONS = "change_icons";//切换图标
    public static final String CLEAR_CACHE = "clear_cache";//清空缓存
    public static final String AUTO_UPDATE = "change_update_time"; //自动更新时长
    public static final String NOTIFICATION_MODEL = "notification_model";
    public static final String ANIM_STRAT = "animation_start";
    public static final String IS_SHOW_NAV = "is_show_nav";//是否显示新手指导

    public static int ONE_HOUR = 1000 * 60 * 60;

    private SharedPreferences mPrefs;

    public static SharedPreferenceUtil getInstance() {
        return SPHolder.sInstance;
    }

    private static class SPHolder {
        private static final SharedPreferenceUtil sInstance = new SharedPreferenceUtil();
    }

    private SharedPreferenceUtil() {
        if (AppConfig.getInstance() != null) {
            mPrefs = AppConfig.getInstance().getApplicationContext().getSharedPreferences("setting", Context.MODE_PRIVATE);
        }
    }

    public SharedPreferenceUtil putInt(String key, int value) {
        if (mPrefs != null) {
            mPrefs.edit().putInt(key, value).apply();
        }
        return this;
    }

    public int getInt(String key, int defValue) {
        return mPrefs.getInt(key, defValue);
    }

    public SharedPreferenceUtil putString(String key, String value) {
        if (mPrefs != null) {
            mPrefs.edit().putString(key, value).apply();

        }
        return this;
    }

    public String getString(String key, String defValue) {
        if (mPrefs != null) {
            return mPrefs.getString(key, defValue);

        } else {
            return null;
        }
    }

    public SharedPreferenceUtil putBoolean(String key, boolean value) {
        if (mPrefs != null) {
            mPrefs.edit().putBoolean(key, value).apply();
        }
        return this;
    }

    public boolean getBoolean(String key, boolean defValue) {
        if (mPrefs != null) {
            return mPrefs.getBoolean(key, defValue);
        } else {
            return false;
        }
    }

    // 设置当前小时
    public void setCurrentHour(int h) {
        mPrefs.edit().putInt(HOUR, h).apply();
    }

    public int getCurrentHour() {
        return mPrefs.getInt(HOUR, 0);
    }

    // 图标种类相关
    public void setIconType(int type) {
        mPrefs.edit().putInt(CHANGE_ICONS, type).apply();
    }

    public int getIconType() {
        if (mPrefs != null) {
            return mPrefs.getInt(CHANGE_ICONS, 0);
        } else {
            return 0;
        }
    }

    // 自动更新时间 hours
    public void setAutoUpdate(int t) {
        mPrefs.edit().putInt(AUTO_UPDATE, t).apply();
    }

    public int getAutoUpdate() {
        return mPrefs.getInt(AUTO_UPDATE, 3);
    }

    //当前城市
    public void setCityName(String name) {
        mPrefs.edit().putString(CITY_NAME, name).apply();
    }

    public String getCityName() {
        return mPrefs.getString(CITY_NAME, "北京");
    }

    //  通知栏模式 默认为常驻
    public void setNotificationModel(int t) {
        mPrefs.edit().putInt(NOTIFICATION_MODEL, t).apply();
    }

    public int getNotificationModel() {
        return mPrefs.getInt(NOTIFICATION_MODEL, Notification.FLAG_ONGOING_EVENT);
    }

    // 首页 Item 动画效果 默认关闭

    public void setMainAnim(boolean b) {
        mPrefs.edit().putBoolean(ANIM_STRAT, b).apply();
    }

    public boolean getMainAnim() {
        return mPrefs.getBoolean(ANIM_STRAT, false);
    }

    public void setIsShowNav(boolean isShowNav){
        mPrefs.edit().putBoolean(IS_SHOW_NAV,isShowNav).apply();
    }

    public boolean isShowNav(){
       return mPrefs.getBoolean(IS_SHOW_NAV,false);
    }
}
