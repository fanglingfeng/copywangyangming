package webhall.tyky.com.wangyangming.bean;

import java.io.Serializable;
import java.util.List;


public class FenleiSearchBean implements Serializable {


    /**
     * _id : 5a28b9505028726c19d5c9ae
     * keywords : 王阳明，王阳明著述
     * press : 机械工业出版社
     * literClassfication : self_writings
     * directories : [{"id":983958508,"name":"教条示龙场诸生 第一回合","serialNo":1,"totalPages":10},{"id":1567365294,"name":"教条示龙场诸生 第二回合","serialNo":2,"totalPages":10},{"id":1378601999,"name":"教条示龙场诸生  第三回合","serialNo":3,"totalPages":10}]
     * readers : 1
     * provider : 中国国家图书馆
     * period : 明朝
     * title : 测试数据误删 (教条示龙场诸生)
     * author : 测试数据不许修改
     * originalPrice : 10.0
     * downloads : 0
     * lastModifiedDate : 2018-02-27 10:42:50
     * thumbnailId : 5a28b9285028726c19d5c9ad
     * totalPage : 30
     * contributionValue : 10
     * literCoverUrl : http://192.9.8.204:9080/ymlib/imgproxy/v1//thumbnails/5a28b9285028726c19d5c9ad_116_122_0.jpg
     * status : 1
     * textId : null
     * dirId : 0
     * pageNo : 1
     * zhHansContent : null
     * zhHantContent : null
     */

    private String _id;
    private String keywords;
    private String press;
    private String literClassfication;
    private int readers;
    private String provider;
    private String period;
    private String title;
    private String author;
    private double originalPrice;
    private int downloads;
    private String lastModifiedDate;
    private String thumbnailId;
    private int totalPage;
    private int contributionValue;
    private String literCoverUrl;
    private String status;
    private Object textId;
    private int dirId;
    private int pageNo;
    private Object zhHansContent;
    private Object zhHantContent;
    private List<DirectoriesBean> directories;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getLiterClassfication() {
        return literClassfication;
    }

    public void setLiterClassfication(String literClassfication) {
        this.literClassfication = literClassfication;
    }

    public int getReaders() {
        return readers;
    }

    public void setReaders(int readers) {
        this.readers = readers;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getThumbnailId() {
        return thumbnailId;
    }

    public void setThumbnailId(String thumbnailId) {
        this.thumbnailId = thumbnailId;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getContributionValue() {
        return contributionValue;
    }

    public void setContributionValue(int contributionValue) {
        this.contributionValue = contributionValue;
    }

    public String getLiterCoverUrl() {
        return literCoverUrl;
    }

    public void setLiterCoverUrl(String literCoverUrl) {
        this.literCoverUrl = literCoverUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getTextId() {
        return textId;
    }

    public void setTextId(Object textId) {
        this.textId = textId;
    }

    public int getDirId() {
        return dirId;
    }

    public void setDirId(int dirId) {
        this.dirId = dirId;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public Object getZhHansContent() {
        return zhHansContent;
    }

    public void setZhHansContent(Object zhHansContent) {
        this.zhHansContent = zhHansContent;
    }

    public Object getZhHantContent() {
        return zhHantContent;
    }

    public void setZhHantContent(Object zhHantContent) {
        this.zhHantContent = zhHantContent;
    }

    public List<DirectoriesBean> getDirectories() {
        return directories;
    }

    public void setDirectories(List<DirectoriesBean> directories) {
        this.directories = directories;
    }

    public static class DirectoriesBean {
        /**
         * id : 983958508
         * name : 教条示龙场诸生 第一回合
         * serialNo : 1
         * totalPages : 10
         */

        private int id;
        private String name;
        private int serialNo;
        private int totalPages;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSerialNo() {
            return serialNo;
        }

        public void setSerialNo(int serialNo) {
            this.serialNo = serialNo;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }
    }
}
