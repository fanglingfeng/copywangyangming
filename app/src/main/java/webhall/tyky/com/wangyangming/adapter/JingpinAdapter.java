package webhall.tyky.com.wangyangming.adapter;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import net.liang.appbaselibrary.base.BindingViewHolder;
import net.liang.appbaselibrary.base.RecyclerView.BaseRecyclerAdapter;

import java.util.List;

import webhall.tyky.com.wangyangming.BR;
import webhall.tyky.com.wangyangming.R;
import webhall.tyky.com.wangyangming.bean.JingpingBean;
import webhall.tyky.com.wangyangming.constants.UrlConstants;
import webhall.tyky.com.wangyangming.utils.GlideUtils;

/**
 * Created by S_Black on 2017/2/21.
 */

public class JingpinAdapter extends BaseRecyclerAdapter<JingpingBean>{
    public JingpinAdapter(Context context, RecyclerView recyclerView, List<JingpingBean> data) {
        super(context, recyclerView, R.layout.item_jingpin,data);
    }

    @Override
    protected void convert(BindingViewHolder bindingViewHolder, JingpingBean jingpingBean) {
        ViewDataBinding binding = bindingViewHolder.getBinding();
        binding.setVariable(BR.jingpin,jingpingBean);
        binding.executePendingBindings();
        String picUrl = UrlConstants.picUrl + jingpingBean.getThumbnailId() + "_720_720_1.jpg";
        GlideUtils.load(picUrl, bindingViewHolder.getView(R.id.iv_service_type));
        ((TextView)bindingViewHolder.getView(R.id.tv_original_price)).getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
    }
}
