package webhall.tyky.com.wangyangming.mvp.login;


import net.liang.appbaselibrary.base.mvp.MvpPresenter;
import net.liang.appbaselibrary.base.mvp.MvpView;

import java.util.Map;

import webhall.tyky.com.wangyangming.bean.AttemptLoginSendBean;

/**
 * Created by Dino on 10/24 0024.
 */

public interface LoginContract {
    /**
     * view接口层  处理界面
     */
    interface View<T> extends MvpView {
        void showProgressDialog(String msg);

        void dismissProgressDialog();

        /**
         * 错误显示
         */
        void loginResult(T bean);

        void showDialog(String tip);

        void sendAuthCodeSuccess();

        void startCount();

        void showAccount(String account);

        void showAccountAndPassword(String account, String password);

        /**
         * 弹出手动设置权限对话框
         */
        void showSetPermissionDialog();

        /**
         * 打开身份拍照验证界面
         */
        void startOcrCaptureActivity();

        /**
         * 去完善用户信息
         */
        void startCompleteUserInfo(Map<String, String> data);

    }

    /**
     * Presenter接口层 处理业务
     */
    interface Presenter extends MvpPresenter {


        void attemptLogin(AttemptLoginSendBean sendBean);


    }
}
