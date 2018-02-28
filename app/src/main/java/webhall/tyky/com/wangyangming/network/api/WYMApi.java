package webhall.tyky.com.wangyangming.network.api;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import webhall.tyky.com.wangyangming.bean.Banner;
import webhall.tyky.com.wangyangming.bean.BaseResponseData;
import webhall.tyky.com.wangyangming.bean.FenleiBean;
import webhall.tyky.com.wangyangming.bean.FenleiSearchBean;
import webhall.tyky.com.wangyangming.bean.JingpingBean;
import webhall.tyky.com.wangyangming.bean.ReadHistoryBean;

/**
 * Created by lenovo on 2017/1/6.
 */

public interface WYMApi {
    /**
     * 轮播图
     */
    @GET("saleActivity/ids")
    Observable<BaseResponseData<Banner>> getBannerList(@QueryMap Map<String, String> params);

    /**
     * 分类
     */
    @GET("literatures/classfications")
    Observable<BaseResponseData<FenleiBean>> getFenlei(@QueryMap Map<String, String> getBannerMap);
    /**
     *精品
     */
    @GET("literatures/choiceness")
    Observable<BaseResponseData<JingpingBean>> getJingping(@QueryMap Map<String, String> getJingpingMap);
    /**
     *最近阅读
     */
    @GET("readerHistory/")
    Observable<BaseResponseData<ReadHistoryBean>> getShufang(@QueryMap Map<String, String> getShufangMap);
    /**
     *分类查询
     */
    @GET("elasticsearch/literatures/groupSearch")
    Observable<BaseResponseData<FenleiSearchBean>> getFenleiSearch(@QueryMap Map<String, Object> getFenleiMap);
}
