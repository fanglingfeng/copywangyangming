package webhall.tyky.com.wangyangming.mvp.home.flcx;

import net.liang.appbaselibrary.base.mvp.MvpPresenter;
import net.liang.appbaselibrary.base.mvp.MvpView;

import io.reactivex.Observable;
import webhall.tyky.com.wangyangming.bean.BaseResponseData;
import webhall.tyky.com.wangyangming.bean.FenleiSearchBean;

/**
 * Created by xieguangwei on 2017/2/22.
 */

public interface FLCXContract {
    interface View extends MvpView {


    }

    interface Presenter extends MvpPresenter {


        Observable<BaseResponseData<FenleiSearchBean>> getFenlei(String author, boolean isFullText, String limit, String literClassfication, String orderValue, String page, String period, String provider, String searchContent, String sortField);
    }
}
