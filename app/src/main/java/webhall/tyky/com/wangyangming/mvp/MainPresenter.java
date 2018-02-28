package webhall.tyky.com.wangyangming.mvp;

import android.support.annotation.NonNull;

import net.liang.appbaselibrary.base.mvp.BasePresenter;

import io.reactivex.disposables.Disposable;
import webhall.tyky.com.wangyangming.data.WYMRepository;
import webhall.tyky.com.wangyangming.data.local.LocalWYMDataSource;
import webhall.tyky.com.wangyangming.data.remote.RemoteWYMDataSource;

import static com.google.common.base.Preconditions.checkNotNull;


/**
 * Created by lenovo on 2017/2/21.
 */

public class MainPresenter extends BasePresenter implements MainContract.Presenter {
    @NonNull
    protected MainContract.View mView;

    @NonNull
    protected WYMRepository repository;
    protected String downloadUrl;
    protected Disposable downloadDisposable;

    public MainPresenter(@NonNull MainContract.View mView) {
        this.mView = checkNotNull(mView);
        this.repository = WYMRepository.getInstance(RemoteWYMDataSource.getInstance(), LocalWYMDataSource.getInstance());
    }




}
