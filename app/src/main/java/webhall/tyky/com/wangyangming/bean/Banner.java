package webhall.tyky.com.wangyangming.bean;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author Administrator
 */
public class Banner implements Serializable {


    /**
     * id : 4089888360b4c4fa0160b4d85fdb0007
     * lang : zh-cn
     * name : 未来活动
     * beginDate : 2018-01-25 00:00:00
     * endDate : 2018-02-15 00:00:00
     * description : sdad
     * advertisingPosition :
     * discount : 3.0
     * status : 1
     * createdDate : 2018-01-02 11:09:27
     * createdUser : 000006bf-8ed0-4a27-956b-b5e441905e64
     * thumbnailId : 5a4af7e1012e801d9c507ae4
     */

    private String id;
    private String lang;
    private String name;
    private String beginDate;
    private String endDate;
    private String description;
    private String advertisingPosition;
    private double discount;
    private int status;
    private String createdDate;
    private String createdUser;
    private String thumbnailId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdvertisingPosition() {
        return advertisingPosition;
    }

    public void setAdvertisingPosition(String advertisingPosition) {
        this.advertisingPosition = advertisingPosition;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getThumbnailId() {
        return thumbnailId;
    }

    public void setThumbnailId(String thumbnailId) {
        this.thumbnailId = thumbnailId;
    }
}
