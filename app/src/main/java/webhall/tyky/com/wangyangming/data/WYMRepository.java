package webhall.tyky.com.wangyangming.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.Gson;

import java.util.Map;

import io.reactivex.Observable;
import webhall.tyky.com.wangyangming.bean.Banner;
import webhall.tyky.com.wangyangming.bean.BaseResponseData;
import webhall.tyky.com.wangyangming.bean.FenleiBean;
import webhall.tyky.com.wangyangming.bean.FenleiSearchBean;
import webhall.tyky.com.wangyangming.bean.JingpingBean;
import webhall.tyky.com.wangyangming.bean.ReadHistoryBean;
import webhall.tyky.com.wangyangming.network.api.WYMApi;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by lenovo on 2017/1/6.
 */

public class WYMRepository implements WYMApi {
    private Gson gson = new Gson();

    @Nullable
    private static WYMRepository INSTANCE = null;

    @NonNull
    private final WYMApi mRemoteDataSource;


    @NonNull
    private final WYMApi mLocalDataSource;

    public WYMRepository(@NonNull WYMApi remoteDataSource,
                         @NonNull WYMApi localDataSource) {
        mRemoteDataSource = checkNotNull(remoteDataSource);
        mLocalDataSource = checkNotNull(localDataSource);
    }

    public static WYMRepository getInstance(@NonNull WYMApi remoteFoodsDataSource,
                                            @NonNull WYMApi localFoodsDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new WYMRepository(remoteFoodsDataSource, localFoodsDataSource);
        }
        return INSTANCE;
    }

    @Override
    public Observable<BaseResponseData<Banner>> getBannerList(Map<String,String> params) {
        return mRemoteDataSource.getBannerList( params);
    }
    @Override
    public Observable<BaseResponseData<FenleiBean>> getFenlei(Map<String,String> params) {
        return mRemoteDataSource.getFenlei( params);
    }
    @Override
    public Observable<BaseResponseData<JingpingBean>> getJingping(Map<String,String> params) {
        return mRemoteDataSource.getJingping( params);
    }
    @Override
    public Observable<BaseResponseData<ReadHistoryBean>> getShufang(Map<String,String> params) {
        return mRemoteDataSource.getShufang( params);
    }
    @Override
    public Observable<BaseResponseData<FenleiSearchBean>> getFenleiSearch(Map<String,Object> params) {
        return mRemoteDataSource.getFenleiSearch( params);
    }
}
