package webhall.tyky.com.wangyangming.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import webhall.tyky.com.wangyangming.R;
import webhall.tyky.com.wangyangming.constants.UrlConstants;

/**
 * Created by lenovo on 2017/2/22.
 */

public class BannerImageHolderView<T> implements Holder<T> {
    private ImageView imageView;

    @Override
    public View createView(Context context) {
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }
// http://192.9.8.204:9080/ymlib/imgproxy/v1/thumbnails/{id_w_h_crop}.jpg
    @Override
    public void UpdateUI(Context context, int position, T data) {
        if (data instanceof String) {
            String picUrl = UrlConstants.picUrl + data + "_720_300_1.jpg";
            Glide.with(imageView.getContext())
                    .load(picUrl)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)//不读取缓存文件
                    .into(imageView);
        } else {
            Glide.with(imageView.getContext())
                    .load(data)
                    .error(R.mipmap.default_back_picture)
                    .placeholder(R.mipmap.default_back_picture)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//读取缓存文件
                    .into(imageView);
        }

    }
}
