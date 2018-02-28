package webhall.tyky.com.wangyangming.data.remote;

import com.google.gson.Gson;
import com.socks.library.KLog;

import io.reactivex.Observable;
import webhall.tyky.com.wangyangming.bean.BaseResponseData;
import webhall.tyky.com.wangyangming.bean.User;
import webhall.tyky.com.wangyangming.network.WYMNetWork;
import webhall.tyky.com.wangyangming.network.api.LoginApi;


/**
 * Created by Dino on 10/25 0025.
 */

public class RemoteUserDataSource implements LoginApi {

    private static RemoteUserDataSource INSTANCE;
    private Gson gson = new Gson();

    public static RemoteUserDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RemoteUserDataSource();
        }
        return INSTANCE;
    }


    @Override
    public Observable<BaseResponseData<User>> attemptLogin(String keywords, String passwords) {
        KLog.d("currentThread:" + Thread.currentThread().getName());
        return WYMNetWork.getLoginApi().attemptLogin(keywords,passwords);
    }



}
