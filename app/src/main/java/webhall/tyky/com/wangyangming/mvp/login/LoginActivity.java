package webhall.tyky.com.wangyangming.mvp.login;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;

import net.liang.appbaselibrary.base.BaseAppCompatActivity;
import net.liang.appbaselibrary.base.mvp.MvpPresenter;
import net.liang.appbaselibrary.utils.KeyboardUtils;
import net.liang.appbaselibrary.utils.SPUtils;
import net.liang.appbaselibrary.widget.dialog.DialogHelper;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import webhall.tyky.com.wangyangming.MainActivity;
import webhall.tyky.com.wangyangming.R;
import webhall.tyky.com.wangyangming.bean.AttemptLoginSendBean;
import webhall.tyky.com.wangyangming.data.UserRepository;
import webhall.tyky.com.wangyangming.data.local.LocalUserDataSource;
import webhall.tyky.com.wangyangming.data.remote.RemoteUserDataSource;
import webhall.tyky.com.wangyangming.databinding.ActivityLoginBinding;


/**
 * 登陆页面
 *
 * @author Administrator
 */
public class LoginActivity extends BaseAppCompatActivity implements LoginContract.View {
    @BindView(R.id.cb_save_password)
    CheckBox cbSavePassword;
    private AttemptLoginSendBean sendBean = new AttemptLoginSendBean();
    private LoginContract.Presenter presenter;
    private DialogHelper dialogHelper;
    @BindView(R.id.iv_isshowpassword)
    ImageView ivIsShowPassword;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.et_account)
    EditText etAccount;
    private ActivityLoginBinding binding;
    private boolean isSavePassword = false;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void init() {
        super.init();
        dialogHelper = new DialogHelper(this);
        binding = (ActivityLoginBinding) getBinding();
        binding.setSendBean(sendBean);
        presenter = new LoginPresenter(this, UserRepository.getInstance(RemoteUserDataSource.getInstance(), LocalUserDataSource.getInstance()));
        isSavePassword = SPUtils.getBoolean("isSavePassword", false);
        cbSavePassword.setChecked(isSavePassword);
        if (isSavePassword) {
            sendBean.setKeywords(SPUtils.getString("keywords"));
            sendBean.setPassword(SPUtils.getString("password"));
        }
    }


    @OnClick({R.id.tv_login})
    public void onClick(View view) {
        KeyboardUtils.hideSoftInput(this);
        switch (view.getId()) {
            case R.id.tv_login://登录

                presenter.attemptLogin(sendBean);
                break;

        }
    }

    @Override
    public void showProgressDialog(String msg) {
        dialogHelper.showProgressDialog(msg);
    }

    @Override
    public void dismissProgressDialog() {
        dialogHelper.dismissProgressDialog();
    }

    @Override
    public void loginResult(Object bean) {
        if (isSavePassword) {
            SPUtils.putString("keywords",sendBean.getKeywords());
            SPUtils.putString("password",sendBean.getPassword());
        }


        showToast("登录成功");
        //登陆
//        AppManager.getAppManager().finishActivity();
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void showDialog(String tip) {

    }

    @Override
    public void sendAuthCodeSuccess() {

    }

    @OnCheckedChanged(R.id.cb_save_password)
    public void onCheckedChange(CompoundButton button, boolean isChecked) {
        switch (button.getId()) {
            case R.id.cb_save_password:
                isSavePassword = isChecked;
                SPUtils.putBoolean("isSavePassword", isSavePassword);
                break;
        }
    }

    @Override
    public void startCount() {

    }

    @Override
    public void showAccount(String account) {

    }

    @Override
    public void showAccountAndPassword(String account, String password) {

    }

    @Override
    public void showSetPermissionDialog() {

    }

    @Override
    public void startOcrCaptureActivity() {

    }

    /**
     * 去完善用户信息
     *
     * @param data
     */
    @Override
    public void startCompleteUserInfo(Map data) {

    }


    @Override
    public void onBackPressed() {
        if (KeyboardUtils.isShowSoftInput(this)) {
            KeyboardUtils.hideSoftInput(this);
        }
        super.onBackPressed();
    }
}
