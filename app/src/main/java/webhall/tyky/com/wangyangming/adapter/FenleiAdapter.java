package webhall.tyky.com.wangyangming.adapter;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import net.liang.appbaselibrary.base.BindingViewHolder;
import net.liang.appbaselibrary.base.RecyclerView.BaseRecyclerAdapter;

import java.util.List;

import webhall.tyky.com.wangyangming.BR;
import webhall.tyky.com.wangyangming.R;
import webhall.tyky.com.wangyangming.bean.FenleiBean;
import webhall.tyky.com.wangyangming.utils.GlideUtils;

/**
 * Created by S_Black on 2017/2/21.
 */

public class FenleiAdapter extends BaseRecyclerAdapter<FenleiBean>{
    public FenleiAdapter(Context context, RecyclerView recyclerView, List<FenleiBean> data) {
        super(context, recyclerView, R.layout.item_fenlei,data);
    }

    @Override
    protected void convert(BindingViewHolder bindingViewHolder, FenleiBean xxgkBean) {
        ViewDataBinding binding = bindingViewHolder.getBinding();
        binding.setVariable(BR.fenlei,xxgkBean);
        binding.executePendingBindings();
        GlideUtils.loadLocal(R.mipmap.ic_launcher, bindingViewHolder.getView(R.id.iv_service_type));
    }
}
