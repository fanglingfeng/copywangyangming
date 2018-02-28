package webhall.tyky.com.wangyangming.bean;

import java.io.Serializable;


public class FenleiBean implements Serializable {


    /**
     * key : self_writings
     * value : 阳明著述
     */

    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
