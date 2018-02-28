package webhall.tyky.com.wangyangming.mvp.shufang;

import android.support.annotation.NonNull;

import net.liang.appbaselibrary.base.mvp.BasePresenter;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import webhall.tyky.com.wangyangming.bean.BaseResponseData;
import webhall.tyky.com.wangyangming.bean.ReadHistoryBean;
import webhall.tyky.com.wangyangming.data.AccountHelper;
import webhall.tyky.com.wangyangming.data.WYMRepository;
import webhall.tyky.com.wangyangming.data.local.LocalWYMDataSource;
import webhall.tyky.com.wangyangming.data.remote.RemoteWYMDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by lenovo on 2017/2/22.
 */

public class ShufangPresenter extends BasePresenter implements ShufangContract.Presenter {
    @NonNull
    private ShufangContract.View mView;
    @NonNull
    private WYMRepository wymRepository;

    public ShufangPresenter(@NonNull ShufangContract.View mView) {
        this.mView = checkNotNull(mView);
        wymRepository = WYMRepository.getInstance(RemoteWYMDataSource.getInstance(), LocalWYMDataSource.getInstance());
    }


    @Override
    public Observable<BaseResponseData<ReadHistoryBean>> getShufang(String days, String page, String pageSize) {
        Map<String,String> getShufangMap = new HashMap<>();
        getShufangMap.put("access_token", AccountHelper.getUser().getAccessToken());
        getShufangMap.put("days", "");
        getShufangMap.put("page","1");
        getShufangMap.put("pageSize","20");



        return wymRepository.getShufang(getShufangMap);
    }
}
