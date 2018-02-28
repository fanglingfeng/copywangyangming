package webhall.tyky.com.wangyangming.data.local;

import android.support.annotation.Nullable;

import io.reactivex.Observable;
import webhall.tyky.com.wangyangming.bean.BaseResponseData;
import webhall.tyky.com.wangyangming.bean.User;
import webhall.tyky.com.wangyangming.network.api.LoginApi;


/**
 * Created by Dino on 10/25 0025.
 */

public class LocalUserDataSource implements LoginApi {
    @Nullable
    private static LocalUserDataSource INSTANCE;


    public static LocalUserDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LocalUserDataSource();
        }
        return INSTANCE;
    }



    @Override
    public Observable<BaseResponseData<User>> attemptLogin(String keywords, String passwords) {
        return null;
    }


}
