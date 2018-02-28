package webhall.tyky.com.wangyangming.mvp.home;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import net.liang.appbaselibrary.base.BaseFragment;
import net.liang.appbaselibrary.base.mvp.MvpPresenter;
import net.liang.appbaselibrary.widget.dialog.DialogHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import webhall.tyky.com.wangyangming.R;
import webhall.tyky.com.wangyangming.adapter.BannerImageHolderView;
import webhall.tyky.com.wangyangming.adapter.FenleiAdapter;
import webhall.tyky.com.wangyangming.adapter.JingpinAdapter;
import webhall.tyky.com.wangyangming.bean.Banner;
import webhall.tyky.com.wangyangming.bean.FenleiBean;
import webhall.tyky.com.wangyangming.bean.JingpingBean;
import webhall.tyky.com.wangyangming.bean.LoadObservableBean;
import webhall.tyky.com.wangyangming.databinding.FragmentHomeBinding;
import webhall.tyky.com.wangyangming.mvp.home.flcx.FLCXActivity;

/**
 * Created by TYKY001 on 2017/6/27.
 */

public class HomeFragment extends BaseFragment implements HomeContract.View {
    @BindView(R.id.banner)
    ConvenientBanner banner;
    private HomeContract.Presenter presenter;
    private DialogHelper dialogHelper;
    @BindView(R.id.rv_fenlei)
    RecyclerView rvFenlei;
    @BindView(R.id.rv_jingpintuijian)
    RecyclerView rvJinpintuijian;
    @BindView(R.id.banner_desc_tv)
    TextView bannerTitle;
    @BindView(R.id.banner_page)
    TextView bannerPage;
    private LoadObservableBean loadObservableBean = new LoadObservableBean();//加载是否成功
    private FragmentHomeBinding binding;
    private FenleiAdapter adapter;
    private JingpinAdapter jingpinAdapter;


    @Override
    protected MvpPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void init() {
        super.init();
        presenter = new HomePresenter(this);
        dialogHelper = new DialogHelper(getActivity());
        binding = (FragmentHomeBinding) getBinding();
        binding.setLoadObservableBean(loadObservableBean);
        dialogHelper = new DialogHelper(getActivity());
        rvFenlei.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        adapter = new FenleiAdapter(getContext(), rvFenlei, null);
        rvFenlei.setAdapter(adapter);


        rvJinpintuijian.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        jingpinAdapter = new JingpinAdapter(getContext(), rvJinpintuijian, null);
        rvJinpintuijian.setAdapter(jingpinAdapter);
        rvJinpintuijian.setNestedScrollingEnabled(false);
        presenter.getBannerNewsList(1, 3);
        presenter.getFenlei(1,7);
        presenter.getjingping(1,4);
        rvFenlei.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                FenleiBean fenleiBean =(FenleiBean) adapter.getData().get(position);
                Intent intent = new Intent(getActivity(),FLCXActivity.class);
                intent.putExtra("literClassfication",fenleiBean.getKey());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }




    @OnClick({R.id.failed_to_load_layout})
    public void onClick(View view) {
        if (view.getId() == R.id.failed_to_load_layout) {
            presenter.getBannerNewsList(1, 3);
        }
    }
    @Override
    public void showProgressDialog(String msg) {
        dialogHelper.showProgressDialog(msg);
    }

    @Override
    public void dismissProgressDialog() {
        dialogHelper.dismissProgressDialog();
    }
    /**
     * 设置banner资源
     *
     * @param banners
     */
    @Override
    public void setBannerData(List<Banner> banners) {
        List<String> imageData = new ArrayList<>();
        for (Banner bean : banners) {
            imageData.add(bean.getThumbnailId());
        }
        if (banners != null && banners.size() > 0) {
            bannerTitle.setText(banners.get(0).getName());
            bannerPage.setText(1 + "/" + banners.size());
        }
        banner.setPages(new CBViewHolderCreator<BannerImageHolderView<String>>() {
            @Override
            public BannerImageHolderView<String> createHolder() {
                return new BannerImageHolderView<String>();
            }
        }, imageData)
//                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
//                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        banner.startTurning(5000);
        banner.setOnItemClickListener(new com.bigkoo.convenientbanner.listener.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }
        });
        banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bannerTitle.setText(banners.get(position).getName());
                bannerPage.setText((position + 1) + "/" + banners.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 分类
     *
     * @param fenleiBeans
     */
    @Override
    public void setFenlei(List<FenleiBean> fenleiBeans) {

        adapter.setNewData(fenleiBeans);

    }
    @Override
    public void setJingpin(List<JingpingBean> jingpingBeans) {

        jingpinAdapter.setNewData(jingpingBeans);

    }

    /**
     * 重新加载页面是否可见
     *
     * @param visibility
     */
    @Override
    public void setReloadVisibility(boolean visibility) {
        loadObservableBean.showReloadLayout.set(visibility);
    }
}
