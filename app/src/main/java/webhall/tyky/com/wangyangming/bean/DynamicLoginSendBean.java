package webhall.tyky.com.wangyangming.bean;

/**
 * Created by Dino on 12/22 0022.
 */

public class DynamicLoginSendBean {
    private String MOBILE;
    private String USERCODE;

    public DynamicLoginSendBean(String MOBILE, String USERCODE){
        this.MOBILE = MOBILE;
        this.USERCODE = USERCODE;
    }

    public String getMOBILE() {
        return MOBILE;
    }

    public void setMOBILE(String MOBILE) {
        this.MOBILE = MOBILE;
    }

    public String getUSERCODE() {
        return USERCODE;
    }

    public void setUSERCODE(String USERCODE) {
        this.USERCODE = USERCODE;
    }
}
