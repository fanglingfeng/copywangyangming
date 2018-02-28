package webhall.tyky.com.wangyangming.utils;

import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;

import webhall.tyky.com.wangyangming.R;

/**
 * 图片加载工具类 for Glide
 * Created by lianghuiyong@outlook.com
 * Date on 2016/9/20
 */
public final class GlideUtils {

    private static int defultImageID = R.mipmap.default_back_picture;

    /**
     * 加载本地图片
     */
    public static void loadLocal(int resId, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(resId)
                .placeholder(defultImageID)
                .crossFade()
                .into(imageView);
    }

    /**
     * 加载SD卡图片文件
     */
    public static void loadLocal(File file, ImageView imageView) {
        if(null!=file && file.isFile() && file.exists()){
            Glide.with(imageView.getContext())
                    .load(file)
                    .placeholder(defultImageID)
                    .crossFade()
                    .into(imageView);
        }
    }

    /**
     * 加载本地、网络图片
     */
    public static void load(String url, ImageView imageView) {
        if(!TextUtils.isEmpty(url)){
            Glide.with(imageView.getContext())
                    .load(url)
                    .placeholder(defultImageID)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//读取缓存文件
//                    .centerCrop()
                    .into(imageView);
        }
    }

    /**
     * 加载转换为byte图片
     * @param bytes
     * @param imageView
     */
    public static void load(byte[] bytes,ImageView imageView) {
        if(bytes != null) {
            Glide.with(imageView.getContext())
                    .load(bytes)
                    .placeholder(defultImageID)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);
        }
    }

    /**
     * 加载本地、网络图片
     */
    public static void loadThumb(String url, ImageView imageView) {
        if(!TextUtils.isEmpty(url)){
            Glide.with(imageView.getContext())
                    .load(url)
                    .placeholder(defultImageID)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//读取缓存文件
                    .thumbnail(0.1f)
                    .into(imageView);
        }
    }


}
