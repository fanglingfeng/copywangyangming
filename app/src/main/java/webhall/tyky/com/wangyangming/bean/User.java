package webhall.tyky.com.wangyangming.bean;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author Administrator
 */
public class User implements Serializable {


    /**
     * id : 2
     * username : demo
     * email : 741623760@qq.com
     * displayName : 秋枫
     * mobile :
     * imgUrl : 5a7d68794775b2200b00002b
     * accessToken : 20bc03b0-267e-474a-9305-f89fea89a966
     * score : 146
     */

    private String id;
    private String username;
    private String email;
    private String displayName;
    private String mobile;
    private String imgUrl;
    private String accessToken;
    private int score;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
