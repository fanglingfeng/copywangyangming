package webhall.tyky.com.wangyangming.mvp.wode;

import android.view.View;

import net.liang.appbaselibrary.base.BaseFragment;
import net.liang.appbaselibrary.base.mvp.MvpPresenter;
import net.liang.appbaselibrary.widget.dialog.DialogHelper;

import butterknife.BindView;
import butterknife.OnClick;
import webhall.tyky.com.wangyangming.R;
import webhall.tyky.com.wangyangming.databinding.MaintabFragmentMyBinding;
import webhall.tyky.com.wangyangming.wights.RoundAngleImageView;


/**
 * Created by lenovo on 2017/1/5.
 */

public class MainTab_My extends BaseFragment {



    private MaintabFragmentMyBinding binding;
    private DialogHelper dialogHelper;
    @BindView(R.id.user_img)
    RoundAngleImageView ivUserImg;


    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.maintab_fragment_my;
    }

    @Override
    public void init() {
        binding = (MaintabFragmentMyBinding) getBinding();

        dialogHelper = new DialogHelper(getActivity());
        initActions();
        loadHeadImg();
    }

    private void initActions() {
        //初始化办事


    }

    private void loadHeadImg() {
//        String picUrl = UrlConstants.picLiteUrl + AccountHelper.getUser().getImgUrl() + "/cover?w=720&h=720&crop=1";
//        GlideUtils.load(picUrl, ivUserImg);
//
    }
    @OnClick({R.id.rl_wodegoumai})
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.rl_wodegoumai:

                

                break;
        }


    }




    @Override
    public void onResume() {
        super.onResume();

    }
}
