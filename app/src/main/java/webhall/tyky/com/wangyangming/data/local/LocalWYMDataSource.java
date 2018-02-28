package webhall.tyky.com.wangyangming.data.local;

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


/**
 * Created by Dino on 10/25 0025.
 */

public class LocalWYMDataSource implements WYMApi {
    @Nullable
    private static LocalWYMDataSource INSTANCE;

    private Gson gson = new Gson();

    public static LocalWYMDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LocalWYMDataSource();
        }
        return INSTANCE;
    }


    /**
     * 轮播图
     *
     * @param params
     */
    @Override
    public Observable<BaseResponseData<Banner>> getBannerList(Map<String, String> params) {
        return null;
    }
    @Override
    public Observable<BaseResponseData<FenleiBean>> getFenlei(Map<String, String> params) {
        return null;
    }
    @Override
    public Observable<BaseResponseData<JingpingBean>> getJingping(Map<String, String> params) {
        return null;
    }
    @Override
    public Observable<BaseResponseData<ReadHistoryBean>> getShufang(Map<String, String> params) {
        return null;
    }
    @Override
    public Observable<BaseResponseData<FenleiSearchBean>> getFenleiSearch(Map<String, Object> params) {
        return null;
    }
}
