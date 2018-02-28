package webhall.tyky.com.wangyangming.bean;

import android.databinding.BaseObservable;

/**
 * Created by Dino on 12/22 0022.
 */

public class GetBannerSendBean extends BaseObservable {
    private String access_token;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    private String page;
    private String size;
}
