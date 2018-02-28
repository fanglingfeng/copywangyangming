package webhall.tyky.com.wangyangming.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.liang.appbaselibrary.utils.ImageLoadUtils;

/**
 * Created by lenovo on 2017/3/31.
 * databinding帮助类，资源文件等的设置
 */

public class BindingUtils {
    @BindingAdapter("bind:textViewBackgroundRes")
    public static void
    BsetTextBackgroundRes(TextView textView, int resId){
        textView.setBackgroundResource(resId);
    }

    @BindingAdapter("bind:textColorRes")
    public static void setTextColor(TextView textView, int resId){
        textView.setTextColor(textView.getContext().getResources().getColor(resId));
    }

    @BindingAdapter("bind:imageViewRes")
    public static void setImageRes(ImageView imageView,int imageRes){
        imageView.setImageResource(imageRes);
    }

//    @BindingAdapter({"bind:imageUrl"})
//    public static void idsetSrc(ImageView imageView, String url) {
//        imageView.setImageResource(CheckBankUtil.getBankIcon(url));
//    }

    @BindingAdapter("bind:imageViewUrl")
    public static void setImageViewUrl(ImageView imageView,String url){
        ImageLoadUtils.loadImage(url,imageView);
    }
}
