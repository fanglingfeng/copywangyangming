package webhall.tyky.com.wangyangming.mvp.home;

import android.support.annotation.NonNull;

import net.liang.appbaselibrary.base.mvp.BasePresenter;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import webhall.tyky.com.wangyangming.bean.Banner;
import webhall.tyky.com.wangyangming.bean.BaseResponseData;
import webhall.tyky.com.wangyangming.bean.FenleiBean;
import webhall.tyky.com.wangyangming.bean.JingpingBean;
import webhall.tyky.com.wangyangming.data.AccountHelper;
import webhall.tyky.com.wangyangming.data.WYMRepository;
import webhall.tyky.com.wangyangming.data.local.LocalWYMDataSource;
import webhall.tyky.com.wangyangming.data.remote.RemoteWYMDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by lenovo on 2017/2/22.
 */

public class HomePresenter extends BasePresenter implements HomeContract.Presenter {
    @NonNull
    private HomeContract.View mView;
    @NonNull
    private WYMRepository wymRepository;

    public HomePresenter(@NonNull HomeContract.View mView) {
        this.mView = checkNotNull(mView);
        wymRepository = WYMRepository.getInstance(RemoteWYMDataSource.getInstance(), LocalWYMDataSource.getInstance());
    }

    @Override
    public void getBannerNewsList(int pageNo, int pageSize) {

        mView.showProgressDialog("正在加载...");
        Map<String,String> getBannerMap = new HashMap<>();
        getBannerMap.put("access_token",AccountHelper.getUser().getAccessToken());
        getBannerMap.put("page","1");
        getBannerMap.put("size","5");



        Disposable disposable = wymRepository.getBannerList(getBannerMap)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<BaseResponseData<Banner>>() {
                    @Override
                    public void onNext(BaseResponseData<Banner> value) {
                        mView.dismissProgressDialog();
                        if(value.getCode() == 200 && value.getData() != null) {
                            mView.setReloadVisibility(false);
                            mView.setBannerData(value.getData());
                        }else {
                            mView.setReloadVisibility(true);
                            mView.showToast("网络出错!");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.setReloadVisibility(true);
                        mView.dismissProgressDialog();
                        mView.showNetworkFail();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        disposables.add(disposable);

    }
    @Override
    public void getjingping(int pageNo, int pageSize) {

        mView.showProgressDialog("正在加载...");
        Map<String,String> getjingpingMap = new HashMap<>();
        getjingpingMap.put("access_token",AccountHelper.getUser().getAccessToken());
        getjingpingMap.put("page","1");
        getjingpingMap.put("pageSize","4");



        Disposable disposable = wymRepository.getJingping(getjingpingMap)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<BaseResponseData<JingpingBean>>() {
                    @Override
                    public void onNext(BaseResponseData<JingpingBean> value) {
                        mView.dismissProgressDialog();
                        if(value.getCode() == 200 && value.getData() != null) {
                            mView.setJingpin(value.getData());

                        }else {
                            mView.showToast("网络出错!");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.dismissProgressDialog();
                        mView.showNetworkFail();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        disposables.add(disposable);

    }
    @Override
    public void getFenlei(int pageNo, int limit) {

        mView.showProgressDialog("正在加载...");
        Map<String,String> getFenleiMap = new HashMap<>();
        getFenleiMap.put("access_token",AccountHelper.getUser().getAccessToken());
        getFenleiMap.put("limit","7");
        getFenleiMap.put("page","1");



        Disposable disposable = wymRepository.getFenlei(getFenleiMap)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<BaseResponseData<FenleiBean>>() {
                    @Override
                    public void onNext(BaseResponseData<FenleiBean> value) {
                        mView.dismissProgressDialog();
                        if(value.getCode() == 200 && value.getData() != null) {
                            mView.setFenlei(value.getData());
                        }else {
                            mView.showToast("网络出错!");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.dismissProgressDialog();
                        mView.showNetworkFail();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        disposables.add(disposable);

    }
}
