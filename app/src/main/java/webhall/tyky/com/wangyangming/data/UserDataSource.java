package webhall.tyky.com.wangyangming.data;


import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import webhall.tyky.com.wangyangming.bean.AttemptLoginSendBean;
import webhall.tyky.com.wangyangming.bean.BaseResponseData;
import webhall.tyky.com.wangyangming.bean.User;

/**
 * Created by Dino on 10/25 0025.
 */

public interface UserDataSource {
    /**
     * 登录
     */
    @POST("user/login")
    Observable<BaseResponseData<User>> attemptLogin(@Body AttemptLoginSendBean sendBean);
}
