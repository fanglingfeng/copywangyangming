package webhall.tyky.com.wangyangming.mvp.login;

import android.support.annotation.NonNull;

import com.socks.library.KLog;

import net.liang.appbaselibrary.base.mvp.BasePresenter;
import net.liang.appbaselibrary.bean.ResponseCode;
import net.liang.appbaselibrary.utils.StringUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import webhall.tyky.com.wangyangming.bean.AttemptLoginSendBean;
import webhall.tyky.com.wangyangming.bean.BaseResponseData;
import webhall.tyky.com.wangyangming.bean.User;
import webhall.tyky.com.wangyangming.data.AccountHelper;
import webhall.tyky.com.wangyangming.data.UserRepository;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Dino on 10/25 0025.
 */

public class LoginPresenter extends BasePresenter implements LoginContract.Presenter {

    @NonNull
    private LoginContract.View view;

    @NonNull
    private UserRepository repository;

    @NonNull
    private CompositeDisposable disposables;


    public LoginPresenter(@NonNull LoginContract.View view,
                          @NonNull UserRepository repository) {
        this.view = checkNotNull(view, "view cannot be null!");
        this.repository = checkNotNull(repository, "repository cannot be null!");
        disposables = new CompositeDisposable();
    }



    @Override
    public void subscribe() {

    }


    @Override
    public void attemptLogin(AttemptLoginSendBean sendBean) {
        if (StringUtils.isEmpty(sendBean.getKeywords())) {
            view.showToast("帐号不能为空");
            return;
        }
        if (StringUtils.isEmpty(sendBean.getPassword())) {
            view.showToast("密码不能为空");
            return;
        }
        view.showProgressDialog("正在登录...");
        Disposable disposable = repository
                .attemptLogin(sendBean.getKeywords(),sendBean.getPassword())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<BaseResponseData<User>>() {
                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.dismissProgressDialog();
                        KLog.e(e.getMessage());
                        view.showNetworkFail();
                    }

                    @Override
                    public void onNext(BaseResponseData<User> response) {
                        view.dismissProgressDialog();
                        KLog.e("response" + response);
                        if(ResponseCode.success == response.getCode()){
                            AccountHelper.login(response.getData().get(0));
                            view.loginResult(response);
                        }else{
                            view.showToast(response.getMsg());
                        }
                    }
                });
        disposables.add(disposable);



    }
}
