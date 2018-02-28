package webhall.tyky.com.wangyangming.mvp.home.flcx;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import net.liang.appbaselibrary.base.RecyclerView.BaseRecyclerAdapter;
import net.liang.appbaselibrary.base.RecyclerView.BaseRecyclerViewActivity;
import net.liang.appbaselibrary.base.mvp.MvpPresenter;
import net.liang.appbaselibrary.bean.ResponseCode;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import webhall.tyky.com.wangyangming.R;
import webhall.tyky.com.wangyangming.adapter.FenleiSearchAdapter;
import webhall.tyky.com.wangyangming.bean.BaseResponseData;
import webhall.tyky.com.wangyangming.bean.FenleiSearchBean;

/**
 * 分类查询页面
 * Created by lenovo on 2018/2/26.
 */

public class FLCXActivity extends BaseRecyclerViewActivity<BaseResponseData<FenleiSearchBean>> implements FLCXContract.View {
    private FLCXContract.Presenter presenter;
    private String literClassfication;//上一级传过来的文献分类
    private String sortField = "";//radiobutton那里的排序选择
    @BindView(R.id.rg_literClassfication)
    RadioGroup rg_literClassfication;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.tv_provider)
    TextView tvProvider;//文献来源
    @BindView(R.id.et_author)
    EditText etAuthor;//文献作者
    @BindView(R.id.et_period)
    EditText etPeriod;//文献年代
    @BindView(R.id.rg_full_search)
    RadioGroup rgFullSearch;//是否全文搜索

    private boolean isGJTSGSelected = false;//国家图书馆是否选上
    private boolean isFullText = false;//是否全文搜索


    @Override
    public void init() {
        super.init();
        presenter = new FLCXPresenter(this);
        setToolbarCentel(true, "分类查询");
        literClassfication = getIntent().getStringExtra("literClassfication");
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, OrientationHelper.VERTICAL));
        rg_literClassfication.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_quanbu:
                        sortField = "";
                        onRefresh();
                        break;
                    case R.id.btn_shijian:
                        sortField = "lastModifiedDate";
                        onRefresh();

                        break;
                    case R.id.btn_yuedu:
                        sortField = "readers";
                        onRefresh();

                        break;
                    case R.id.btn_xiazai:
                        sortField = "downloads";
                        onRefresh();

                        break;

                }
            }
        });
        rgFullSearch.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_wxss:
                        isFullText = false;
                        break;
                    case R.id.rb_qwss:
                        isFullText = true;
                        break;

                }
            }
        });
    }

    @OnClick({R.id.btn_saixuan, R.id.tv_provider,R.id.tv_search,R.id.tv_close})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_saixuan:
                drawerLayout.openDrawer(Gravity.RIGHT, true);
                break;
            case R.id.tv_provider:
                if (isGJTSGSelected) {
                    tvProvider.setSelected(true);
                } else {
                    tvProvider.setSelected(false);
                }
                isGJTSGSelected = !isGJTSGSelected;


                break;
            case R.id.tv_search:
                onRefresh();
                drawerLayout.closeDrawers();


                break;
            case R.id.tv_close:

                drawerLayout.closeDrawers();


                break;

        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_flcx;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void onListSuccess(BaseResponseData<FenleiSearchBean> fenleiSearchBeans, int pageNo) {
        switch (fenleiSearchBeans.getCode()) {
            case ResponseCode.success:

                adapter.showList(fenleiSearchBeans.getData());
                if (fenleiSearchBeans.getData() == null || fenleiSearchBeans.getData().size() <= 0) {
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
        return new FenleiSearchAdapter(FLCXActivity.this, recyclerView, null);
    }

    @Override
    public Observable<BaseResponseData<FenleiSearchBean>> onListGetData(int pageNo) {


        return presenter.getFenlei(etAuthor.getText().toString(), isFullText, "20", literClassfication, "DESC", "1", etPeriod.getText().toString(), "", "", sortField);
    }
}
