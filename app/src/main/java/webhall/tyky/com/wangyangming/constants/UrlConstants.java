package webhall.tyky.com.wangyangming.constants;


/**
 * Created by Dino on 9/20 0020.
 */

public class UrlConstants {

    public static final String NAMESPACE = "http://service.rest2.cms.jeecms.com/";


    //------------wangyangmin测试地址-------------
    public volatile static String DOMAIN = "http://192.9.8.144:9999/";

    public volatile static String LIBDOMAIN = " http://192.9.8.144:80/";
    //登录地址
    public static final String LoginUrl = DOMAIN + "educloud-management/api/v1/registers/";
    //主页地址
    public static final String wymUrl = LIBDOMAIN + "ymlib/api/v1/";
    //获取图片
    public static final String picUrl = "http://192.9.8.204:9080/ymlib/imgproxy/v1/thumbnails/";
    //获取文献封面图片
    public static final String picLiteUrl = "http://192.9.8.204:9080/ymlib/imgproxy/v1/";


}