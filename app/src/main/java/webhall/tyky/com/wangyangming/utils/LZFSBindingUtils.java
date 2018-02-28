package webhall.tyky.com.wangyangming.utils;

/**
 * Created by lenovo on 2017/4/1.
 * 领证方式databinding帮助类
 */

public class LZFSBindingUtils {
    public static String getDJTitle(int STATUS){
        if (STATUS != -1 && STATUS != 4 && STATUS != 9) {
            return "已选择递交材料方式：";
        } else {
            return "请选择递交材料方式：";
        }
    }

    public static String getLQTitle(int STATUS){
        if (STATUS != -1 && STATUS != 4 && STATUS != 9) {
            return "已选择领取证照方式：";
        } else {
            return "请选择领取证照方式：";
        }
    }
}
