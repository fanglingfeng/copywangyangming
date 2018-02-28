package webhall.tyky.com.wangyangming.mvp.shufang;

import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.StaggeredGridLayoutManager;

import net.liang.appbaselibrary.base.RecyclerView.BaseRecyclerAdapter;
import net.liang.appbaselibrary.base.RecyclerView.BaseRecyclerViewFragment;
import net.liang.appbaselibrary.base.mvp.MvpPresenter;
import net.liang.appbaselibrary.bean.ResponseCode;

import io.reactivex.Observable;
import webhall.tyky.com.wangyangming.R;
import webhall.tyky.com.wangyangming.adapter.ReadHistoryAdapter;
import webhall.tyky.com.wangyangming.bean.BaseResponseData;
import webhall.tyky.com.wangyangming.bean.ReadHistoryBean;

/**
 * Created by lenovo on 2018/2/23.
 */

public class ShufangFragment extends BaseRecyclerViewFragment<BaseResponseData<ReadHistoryBean>> implements ShufangContract.View {
    private ShufangContract.Presenter presenter;

    @Override
    public void init() {
        super.init();
        presenter = new ShufangPresenter(this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));
    }

    @Override
    protected MvpPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shufang;
    }


    @Override
    public void onListSuccess(BaseResponseData<ReadHistoryBean> readHistoryBeans, int pageNo) {
        switch (readHistoryBeans.getCode()) {
            case ResponseCode.success:

                adapter.showList(readHistoryBeans.getData());
                if(readHistoryBeans.getData() == null || readHistoryBeans.getData().size() <= 0) {
                    adapter.loadMoreEnd(true);
                }
                break;

            default:
                showNetworkFail();
                break;
        }
    }

    @Override
    public BaseRecyclerAdapter addListAdapter() {
        return new ReadHistoryAdapter(getContext(),recyclerView,null);
    }

    @Override
    public Observable<BaseResponseData<ReadHistoryBean>> onListGetData(int pageNo) {
        return presenter.getShufang("","1","1000");
    }
}
