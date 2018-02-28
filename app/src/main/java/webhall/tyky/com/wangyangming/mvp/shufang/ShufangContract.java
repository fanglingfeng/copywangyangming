package webhall.tyky.com.wangyangming.mvp.shufang;

import net.liang.appbaselibrary.base.mvp.MvpPresenter;
import net.liang.appbaselibrary.base.mvp.MvpView;

import io.reactivex.Observable;
import webhall.tyky.com.wangyangming.bean.BaseResponseData;
import webhall.tyky.com.wangyangming.bean.ReadHistoryBean;

/**
 * Created by xieguangwei on 2017/2/22.
 */

public interface ShufangContract {
    interface View extends MvpView {


    }

    interface Presenter extends MvpPresenter {


        Observable<BaseResponseData<ReadHistoryBean>> getShufang(String days, String page, String pageSize);
    }
}
