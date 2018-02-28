package webhall.tyky.com.wangyangming.adapter;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

import net.liang.appbaselibrary.base.BindingViewHolder;
import net.liang.appbaselibrary.base.RecyclerView.BaseRecyclerAdapter;

import java.util.List;

import webhall.tyky.com.wangyangming.BR;
import webhall.tyky.com.wangyangming.R;
import webhall.tyky.com.wangyangming.bean.ReadHistoryBean;
import webhall.tyky.com.wangyangming.constants.UrlConstants;
import webhall.tyky.com.wangyangming.utils.GlideUtils;

/**
 * Created by S_Black on 2017/2/21.
 */

public class ReadHistoryAdapter extends BaseRecyclerAdapter<ReadHistoryBean>{
    public ReadHistoryAdapter(Context context, RecyclerView recyclerView, List<ReadHistoryBean> data) {
        super(context, recyclerView, R.layout.item_read_history,data);
    }

    @Override
    protected void convert(BindingViewHolder bindingViewHolder, ReadHistoryBean readHistoryBean) {
        ViewDataBinding binding = bindingViewHolder.getBinding();
        binding.setVariable(BR.readhistory,readHistoryBean);
        binding.executePendingBindings();
        // http://192.9.8.204:9080/ymlib/imgproxy/v1/{literId}/cover?w=&h=&crop=
        String picUrl = UrlConstants.picLiteUrl + readHistoryBean.getLiteratureId() + "/cover?w=720&h=720&crop=1";
        GlideUtils.load(picUrl, bindingViewHolder.getView(R.id.iv_service_type));
        TextView tvReadRate = (TextView) bindingViewHolder.getView(R.id.tv_read_rate);
        ProgressBar pbReadRate = (ProgressBar) bindingViewHolder.getView(R.id.pb_read_rate);
        if (readHistoryBean.getReadRate() > 0) {
            double rate = (int) (readHistoryBean.getReadRate() * 1000) / 10.0;
            tvReadRate.setText("已读" + rate+"%");
        } else {
            tvReadRate.setText("未读");
        }
        pbReadRate.setMax(100);
        pbReadRate.setProgress((int)(readHistoryBean.getReadRate()*100));
    }
}
