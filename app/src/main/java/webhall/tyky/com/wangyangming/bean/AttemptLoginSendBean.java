package webhall.tyky.com.wangyangming.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Dino on 12/22 0022.
 */

public class AttemptLoginSendBean extends BaseObservable {
    @Bindable
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String keywords;
   private String password;
}
