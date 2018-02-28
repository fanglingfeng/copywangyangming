package webhall.tyky.com.wangyangming.data.remote;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;
import java.util.Map;

import io.reactivex.Observable;
import webhall.tyky.com.wangyangming.bean.Banner;
import webhall.tyky.com.wangyangming.bean.BaseResponseData;
import webhall.tyky.com.wangyangming.bean.FenleiBean;
import webhall.tyky.com.wangyangming.bean.FenleiSearchBean;
import webhall.tyky.com.wangyangming.bean.JingpingBean;
import webhall.tyky.com.wangyangming.bean.ReadHistoryBean;
import webhall.tyky.com.wangyangming.network.WYMNetWork;
import webhall.tyky.com.wangyangming.network.api.WYMApi;


/**
 * Created by Dino on 10/25 0025.
 */

public class RemoteWYMDataSource implements WYMApi {

    private static RemoteWYMDataSource INSTANCE;
    private MyCson gson = new MyCson();

    public static RemoteWYMDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RemoteWYMDataSource();
        }
        return INSTANCE;
    }



    class MyCson {

        Gson mGson = new Gson();

        public <T> T fromJson(String json, Type typeOfT) {
            try {
                return mGson.fromJson(json, typeOfT);
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
                return null;
            }
        }

        public String toJson(Object src) {
            return mGson.toJson(src);
        }
    }
    /**
     * 轮播图
     *
     * @param params
     */
    @Override
    public Observable<BaseResponseData<Banner>> getBannerList(Map<String, String> params) {
        return WYMNetWork.getWymApi().getBannerList(params);
    }
    @Override
    public Observable<BaseResponseData<FenleiBean>> getFenlei(Map<String, String> params) {
        return WYMNetWork.getWymApi().getFenlei(params);
    }
    @Override
    public Observable<BaseResponseData<JingpingBean>> getJingping(Map<String, String> params) {
        return WYMNetWork.getWymApi().getJingping(params);
    }
    @Override
    public Observable<BaseResponseData<ReadHistoryBean>> getShufang(Map<String, String> params) {
        return WYMNetWork.getWymApi().getShufang(params);
    }
    @Override
    public Observable<BaseResponseData<FenleiSearchBean>> getFenleiSearch(Map<String, Object> params) {
        return WYMNetWork.getWymApi().getFenleiSearch(params);
    }

}
