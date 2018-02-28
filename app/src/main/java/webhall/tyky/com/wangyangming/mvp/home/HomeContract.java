package webhall.tyky.com.wangyangming.mvp.home;

import net.liang.appbaselibrary.base.mvp.MvpPresenter;
import net.liang.appbaselibrary.base.mvp.MvpView;

import java.util.List;

import webhall.tyky.com.wangyangming.bean.Banner;
import webhall.tyky.com.wangyangming.bean.FenleiBean;
import webhall.tyky.com.wangyangming.bean.JingpingBean;

/**
 * Created by xieguangwei on 2017/2/22.
 */

public interface HomeContract {
    interface View extends MvpView {

        /**
         * 设置banner资源
         * @param bannerImgRes
         */
        void setBannerData(List<Banner> bannerImgRes);
        /**
         * 设置分类资源
         * @param fenleiBeans
         */
        void setFenlei(List<FenleiBean> fenleiBeans);
        /**
         * 设置精品资源
         * @param jingpingBeans
         */
        void setJingpin(List<JingpingBean> jingpingBeans);


        void setReloadVisibility(boolean b);
        /**
         * 显示加载进度
         */
        void showProgressDialog(String msg);
        /**
         * 隐藏加载进度
         */
        void dismissProgressDialog();
    }
    interface Presenter extends MvpPresenter {


        void getBannerNewsList(int pagenum, int pagesize);

        void getjingping(int page, int pagesize);

        void getFenlei(int page, int limit);
    }
}
