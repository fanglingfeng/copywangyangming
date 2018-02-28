package webhall.tyky.com.wangyangming.data;

import android.annotation.SuppressLint;
import android.app.Application;

import com.google.gson.Gson;
import com.socks.library.KLog;

import net.liang.appbaselibrary.utils.SPUtils;

import webhall.tyky.com.wangyangming.bean.User;
import webhall.tyky.com.wangyangming.bean.UserDetail;


/**
 * by：梁惠涌
 * 账户辅助类，
 * 用于更新用户信息和保存当前账户等操作
 */
public final class AccountHelper {
    private static String SP_USER_KEY = "SP_USER_KEY";
    private static String SP_USERDETAIL_KEY = "SP_USERDETAIL_KEY";
    private User user;
    private UserDetail userDetail;
    private Application application;
    @SuppressLint("StaticFieldLeak")
    private static AccountHelper instances;

    private AccountHelper(Application application) {
        this.application = application;
    }

    public static void init(Application application) {
        instances = new AccountHelper(application);
    }

    /**
     * 判断是否登录
     * */
    public static boolean isLogin() {
//        return getUser().isLogin();
        return true;
    }

    /**
     * 判断是否登录
     * */
    public static boolean isGetDetail() {
        //UserId 默认 "null"
        return getUserDetail().isGet();
    }

    public static String getUserId() {
//        return getUser().getUSER_ID();
        return "";
    }

    /**
     * 获取用户
     * */
    public synchronized static User getUser() {
        if (instances == null) {
            KLog.e("AccountHelper instances is null, you need call init() method.");
            return new User();
        }
        if (instances.user == null) {
            String userStr = SPUtils.getString(SP_USER_KEY);
            instances.user = new Gson().fromJson(userStr,User.class);
        }
        if (instances.user == null)
            instances.user = new User();

        //KLog.e(new Gson().toJson(instances.user));
        return instances.user;
    }

    /**
     * 更新用户信息
     * */
    private static void updateUserCache(User user) {
        if (user == null)
            return;

        //登录状态为真
//        user.setLogin(true);

        instances.user = user;
        SPUtils.putString(SP_USER_KEY,new Gson().toJson(user));
    }

    /**
     * 清除用户信息
     * */
    private static void clearUserCache() {
        //只保存用户用户名（手机号）
        User user = new User();
//        user.setLogin(false);
//        user.setMOBILE(getUser().getMOBILE());
        instances.user = null;
        SPUtils.putString(SP_USER_KEY,new Gson().toJson(user));

        //清空用户详情
        instances.userDetail = null;
        SPUtils.remove(SP_USERDETAIL_KEY);
    }

    /**
     * 保存用户详情
     * */
    public static void saveUserDetail(UserDetail userDetail){
        if (userDetail == null)
            return;

        //更换用户详情是否获取到的状态
        userDetail.setGet(true);
        instances.userDetail = userDetail;
        SPUtils.putString(SP_USERDETAIL_KEY,new Gson().toJson(userDetail));
    }

    /**
     * 获取用户详情
     * */
    public synchronized static UserDetail getUserDetail() {
        if (instances == null) {
            KLog.e("AccountHelper instances is null, you need call init() method.");
            return new UserDetail();
        }
        if (instances.user == null) {
            String userDetailStr = SPUtils.getString(SP_USERDETAIL_KEY);
            instances.userDetail = new Gson().fromJson(userDetailStr,UserDetail.class);
        }
        if (instances.userDetail == null)
            instances.userDetail = new UserDetail();
        return instances.userDetail;
    }

    /**
     * 用户登录
     * */
    public static void login(User user) {
        // 保存User缓存
        updateUserCache(user);
    }

    /**
     * 退出登陆
     */
    public static void logout() {
        // 清除用户缓存
        clearUserCache();
    }
}
