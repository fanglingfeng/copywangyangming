package webhall.tyky.com.wangyangming.network.api;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import webhall.tyky.com.wangyangming.bean.BaseResponseData;
import webhall.tyky.com.wangyangming.bean.User;

/**
 * Created by TYKY001 on 2017/10/26.
 */

public interface LoginApi {

    /**
     * 登录
     */
    @FormUrlEncoded
    @POST("user/login")
    Observable<BaseResponseData<User>> attemptLogin(@Field("keywords") String first, @Field("password") String last);


}
