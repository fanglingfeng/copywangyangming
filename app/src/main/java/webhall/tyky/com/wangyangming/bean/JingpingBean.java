package webhall.tyky.com.wangyangming.bean;

import java.io.Serializable;
import java.util.List;


public class JingpingBean implements Serializable {


    /**
     * id : 5a02f4f0f8fbac0a0464e0c0
     * keywords : 关键词
     * directories : [{"id":546995867,"name":"56812321","serialNo":1,"totalPages":0},{"id":1222176815,"name":"1232312","serialNo":2,"totalPages":0},{"id":18324091,"name":"234","serialNo":3,"totalPages":0},{"id":774725091,"name":"3453234","serialNo":4,"totalPages":0}]
     * provider : 读者投稿
     * period : 宋朝
     * createDate : null
     * lastModifiedDate : 2017-12-12 16:18:38
     * modifiedBy : null
     * previewThreshold : 1
     * title : 王阳明著述2232
     * author : 作者
     * press : 出版社
     * nIndexNo : GT118733432342
     * literType : fangzhi
     * literClassfication : generations_finishing
     * volumes : 2
     * remark :
     * thumbnailId : 5a2f90dcf8fbac16b89ee4d1
     * totalPage : 10
     * updatePDF : true
     * tips :
     * originalPrice : 90.9
     * contributionValue : 10
     * promotionPrice : 50.0
     * favorites : 2
     * downloads : 0
     * readers : 3
     * previewers : 13
     * buyers : 0
     * salesAmount : 0.0
     * status : 1
     */

    private String id;
    private String keywords;
    private String provider;
    private String period;
    private Object createDate;
    private String lastModifiedDate;
    private Object modifiedBy;
    private int previewThreshold;
    private String title;
    private String author;
    private String press;
    private String nIndexNo;
    private String literType;
    private String literClassfication;
    private String volumes;
    private String remark;
    private String thumbnailId;
    private int totalPage;
    private boolean updatePDF;
    private String tips;
    private double originalPrice;
    private int contributionValue;
    private double promotionPrice;
    private int favorites;
    private int downloads;
    private int readers;
    private int previewers;
    private int buyers;
    private double salesAmount;
    private String status;
    private List<DirectoriesBean> directories;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
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

    public Object getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Object createDate) {
        this.createDate = createDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Object getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Object modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public int getPreviewThreshold() {
        return previewThreshold;
    }

    public void setPreviewThreshold(int previewThreshold) {
        this.previewThreshold = previewThreshold;
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

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getNIndexNo() {
        return nIndexNo;
    }

    public void setNIndexNo(String nIndexNo) {
        this.nIndexNo = nIndexNo;
    }

    public String getLiterType() {
        return literType;
    }

    public void setLiterType(String literType) {
        this.literType = literType;
    }

    public String getLiterClassfication() {
        return literClassfication;
    }

    public void setLiterClassfication(String literClassfication) {
        this.literClassfication = literClassfication;
    }

    public String getVolumes() {
        return volumes;
    }

    public void setVolumes(String volumes) {
        this.volumes = volumes;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public boolean isUpdatePDF() {
        return updatePDF;
    }

    public void setUpdatePDF(boolean updatePDF) {
        this.updatePDF = updatePDF;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getContributionValue() {
        return contributionValue;
    }

    public void setContributionValue(int contributionValue) {
        this.contributionValue = contributionValue;
    }

    public double getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(double promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public int getReaders() {
        return readers;
    }

    public void setReaders(int readers) {
        this.readers = readers;
    }

    public int getPreviewers() {
        return previewers;
    }

    public void setPreviewers(int previewers) {
        this.previewers = previewers;
    }

    public int getBuyers() {
        return buyers;
    }

    public void setBuyers(int buyers) {
        this.buyers = buyers;
    }

    public double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(double salesAmount) {
        this.salesAmount = salesAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DirectoriesBean> getDirectories() {
        return directories;
    }

    public void setDirectories(List<DirectoriesBean> directories) {
        this.directories = directories;
    }

    public static class DirectoriesBean {
        /**
         * id : 546995867
         * name : 56812321
         * serialNo : 1
         * totalPages : 0
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
