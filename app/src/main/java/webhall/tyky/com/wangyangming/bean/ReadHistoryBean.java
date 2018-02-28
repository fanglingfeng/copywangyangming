package webhall.tyky.com.wangyangming.bean;

import java.io.Serializable;


public class ReadHistoryBean implements Serializable {


    /**
     * id : ff8080816059cb1001605daa6a8500f5
     * lang : zh-cn
     * uid : 2
     * literatureId : 5a1e5daff8fbac09b4614ccb
     * literatureName : 王阳明著述1129
     * pageNo : 1
     * dirId : 453040554
     * dirName : 九阳神功
     * lastReadDate : 2018-02-13 11:11:58
     * status : 0
     * readRate : 0.058823529411764705
     */

    private String id;
    private String lang;
    private String uid;
    private String literatureId;
    private String literatureName;
    private int pageNo;
    private String dirId;
    private String dirName;
    private String lastReadDate;
    private int status;
    private double readRate;

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLiteratureId() {
        return literatureId;
    }

    public void setLiteratureId(String literatureId) {
        this.literatureId = literatureId;
    }

    public String getLiteratureName() {
        return literatureName;
    }

    public void setLiteratureName(String literatureName) {
        this.literatureName = literatureName;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public String getDirId() {
        return dirId;
    }

    public void setDirId(String dirId) {
        this.dirId = dirId;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public String getLastReadDate() {
        return lastReadDate;
    }

    public void setLastReadDate(String lastReadDate) {
        this.lastReadDate = lastReadDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getReadRate() {
        return readRate;
    }

    public void setReadRate(double readRate) {
        this.readRate = readRate;
    }
}
