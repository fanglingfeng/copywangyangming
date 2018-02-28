package webhall.tyky.com.wangyangming.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.reactivex.Observable;
import webhall.tyky.com.wangyangming.bean.BaseResponseData;
import webhall.tyky.com.wangyangming.bean.User;
import webhall.tyky.com.wangyangming.network.api.LoginApi;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Dino on 10/25 0025.
 */

public class UserRepository implements LoginApi {
    @Nullable
    private static UserRepository INSTANCE = null;

    @NonNull
    private final LoginApi mRemoteDataSource;

    @NonNull
    private final LoginApi mLocalDataSource;

    private UserRepository(@NonNull LoginApi remoteDataSource,
                           @NonNull LoginApi localDataSource) {
        mRemoteDataSource = checkNotNull(remoteDataSource);
        mLocalDataSource = checkNotNull(localDataSource);
    }

    public static UserRepository getInstance(@NonNull LoginApi remoteFoodsDataSource,
                                             @NonNull LoginApi localFoodsDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new UserRepository(remoteFoodsDataSource, localFoodsDataSource);
        }
        return INSTANCE;
    }


    @Override
    public Observable<BaseResponseData<User>> attemptLogin(String keywords, String passwords) {
        return mRemoteDataSource.attemptLogin(keywords,passwords);
    }

}
