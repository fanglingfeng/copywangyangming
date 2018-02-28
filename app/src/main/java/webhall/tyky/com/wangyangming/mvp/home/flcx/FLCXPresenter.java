package webhall.tyky.com.wangyangming.mvp.home.flcx;

import android.support.annotation.NonNull;

import net.liang.appbaselibrary.base.mvp.BasePresenter;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import webhall.tyky.com.wangyangming.bean.BaseResponseData;
import webhall.tyky.com.wangyangming.bean.FenleiSearchBean;
import webhall.tyky.com.wangyangming.data.AccountHelper;
import webhall.tyky.com.wangyangming.data.WYMRepository;
import webhall.tyky.com.wangyangming.data.local.LocalWYMDataSource;
import webhall.tyky.com.wangyangming.data.remote.RemoteWYMDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by lenovo on 2017/2/22.
 */

public class FLCXPresenter extends BasePresenter implements FLCXContract.Presenter {
    @NonNull
    private FLCXContract.View mView;
    @NonNull
    private WYMRepository wymRepository;

    public FLCXPresenter(@NonNull FLCXContract.View mView) {
        this.mView = checkNotNull(mView);
        wymRepository = WYMRepository.getInstance(RemoteWYMDataSource.getInstance(), LocalWYMDataSource.getInstance());
    }


    @Override
    public Observable<BaseResponseData<FenleiSearchBean>> getFenlei(String author, boolean isFullText, String limit, String literClassfication, String orderValue, String page, String period, String provider, String searchContent, String sortField) {
        Map<String, Object> getFenleiMap = new HashMap<>();
        getFenleiMap.put("access_token", AccountHelper.getUser().getAccessToken());

        getFenleiMap.put("author", author);
        getFenleiMap.put("isFullText", false);
        getFenleiMap.put("limit", limit);
        getFenleiMap.put("literClassfication", literClassfication);
        getFenleiMap.put("orderValue", orderValue);
        getFenleiMap.put("page", page);
        getFenleiMap.put("period", period);
        getFenleiMap.put("provider", provider);
        getFenleiMap.put("searchContent", searchContent);
        getFenleiMap.put("sortField", sortField);
        getFenleiMap.put("sortField", sortField);


        return wymRepository.getFenleiSearch(getFenleiMap);
    }
}
