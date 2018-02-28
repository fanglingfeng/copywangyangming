package webhall.tyky.com.wangyangming.bean;

import android.text.TextUtils;

import java.io.Serializable;

/**
 * 用户详情实体类
 *
 * @author Administrator
 */
public class UserDetail implements Serializable {
    private boolean isGet = false;
    private String TYPE = "";
    private String USER_NAME = "";
    private String USER_GENDER = "";
    private String CERTIFICATETYPE = "";
    private String USER_PID = "";
    private String USER_PHONE = "";
    private String USER_MOBILE = "";
    private String USER_EMAIL = "";
    private String USER_ADDRESS = "";
    private String USER_INDICIA = "";
    private String INC_NAME = "";
    private String INC_ADDR = "";//企业地址
    private String INC_CARDTYPE = "";//企业法人证件类型
    private String INC_TYPE = "";
    private String INC_PERMIT = "";
    private String INC_ZZJGDM = "";
    private String INC_DEPUTY = "";
    private String INC_DEPUTY_MOBILE = "";
    private String INC_PID = "";
    private String AGE_NAME = "";
    private String AGE_PID = "";
    private String AGE_EMAIL = "";
    private String AGE_MOBILE = "";
    private String AGE_PHONE = "";
    private String AGE_INDICIA = "";
    private String AGE_ADDR = "";
    private String IMG_FRONT = "";
    private String IMG_BACK = "";
    private String ISREALNAME = "";
    private String AUTHLEVEL = "";//认证级别（1密码级(初级)，2实名级别(中级)，3实人级别(高级1)，4CA级别(高级2)
    private String PRJ_NAME = "";//当前申请的项目，为的是传给表单， 让表单自动填充
    //微信相关
    private String WXUSERID;
    private String WXUSERNAME;
    private String WXUSERIMG;

    public String getUSERIMG() {
        return USERIMG;
    }

    public void setUSERIMG(String USERIMG) {
        this.USERIMG = USERIMG;
    }

    private String USERIMG;//头像显示


    public boolean isGet() {
        return isGet;
    }

    public void setGet(boolean get) {
        isGet = get;
    }

    public String getIMG_BACK() {
        return IMG_BACK;
    }

    public void setIMG_BACK(String iMG_BACK) {
        IMG_BACK = iMG_BACK;
    }

    public String getIMG_FRONT() {
        return IMG_FRONT;
    }

    public void setIMG_FRONT(String iMG_FRONT) {
        IMG_FRONT = iMG_FRONT;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String tYPE) {
        TYPE = tYPE;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String uSER_NAME) {
        USER_NAME = uSER_NAME;
    }

    public String getUSER_GENDER() {
        return USER_GENDER;
    }

    public void setUSER_GENDER(String uSER_GENDER) {
        USER_GENDER = uSER_GENDER;
    }

    public String getCERTIFICATETYPE() {
        return CERTIFICATETYPE;
    }

    public void setCERTIFICATETYPE(String cERTIFICATETYPE) {
        CERTIFICATETYPE = cERTIFICATETYPE;
    }

    public String getUSER_PID() {
        return USER_PID;
    }

    public void setUSER_PID(String uSER_PID) {
        USER_PID = uSER_PID;
    }

    public String getUSER_PHONE() {
        return USER_PHONE;
    }

    public void setUSER_PHONE(String uSER_PHONE) {
        USER_PHONE = uSER_PHONE;
    }

    public String getUSER_MOBILE() {
        return USER_MOBILE;
    }

    public void setUSER_MOBILE(String uSER_MOBILE) {
        USER_MOBILE = uSER_MOBILE;
    }

    public String getUSER_EMAIL() {
        return USER_EMAIL;
    }

    public void setUSER_EMAIL(String uSER_EMAIL) {
        USER_EMAIL = uSER_EMAIL;
    }

    public String getUSER_ADDRESS() {
        return USER_ADDRESS;
    }

    public void setUSER_ADDRESS(String uSER_ADDRESS) {
        USER_ADDRESS = uSER_ADDRESS;
    }

    public String getUSER_INDICIA() {
        return USER_INDICIA;
    }

    public void setUSER_INDICIA(String uSER_INDICIA) {
        USER_INDICIA = uSER_INDICIA;
    }

    public String getINC_NAME() {
        return INC_NAME;
    }

    public void setINC_NAME(String iNC_NAME) {
        INC_NAME = iNC_NAME;
    }

    public String getINC_TYPE() {
        return INC_TYPE;
    }

    public void setINC_TYPE(String iNC_TYPE) {
        INC_TYPE = iNC_TYPE;
    }

    public String getINC_PERMIT() {
        return INC_PERMIT;
    }

    public void setINC_PERMIT(String iNC_PERMIT) {
        INC_PERMIT = iNC_PERMIT;
    }

    public String getINC_ZZJGDM() {
        return INC_ZZJGDM;
    }

    public void setINC_ZZJGDM(String iNC_ZZJGDM) {
        INC_ZZJGDM = iNC_ZZJGDM;
    }

    public String getINC_DEPUTY() {
        return INC_DEPUTY;
    }

    public void setINC_DEPUTY(String iNC_DEPUTY) {
        INC_DEPUTY = iNC_DEPUTY;
    }

    public String getINC_PID() {
        return INC_PID;
    }

    public void setINC_PID(String iNC_PID) {
        INC_PID = iNC_PID;
    }

    public String getAGE_NAME() {
        return AGE_NAME;
    }

    public void setAGE_NAME(String aGE_NAME) {
        AGE_NAME = aGE_NAME;
    }

    public String getAGE_PID() {
        return AGE_PID;
    }

    public void setAGE_PID(String aGE_PID) {
        AGE_PID = aGE_PID;
    }

    public String getAGE_EMAIL() {
        return AGE_EMAIL;
    }

    public void setAGE_EMAIL(String aGE_EMAIL) {
        AGE_EMAIL = aGE_EMAIL;
    }

    public String getAGE_MOBILE() {
        return AGE_MOBILE;
    }

    public void setAGE_MOBILE(String aGE_MOBILE) {
        AGE_MOBILE = aGE_MOBILE;
    }

    public String getAGE_PHONE() {
        return AGE_PHONE;
    }

    public void setAGE_PHONE(String aGE_PHONE) {
        AGE_PHONE = aGE_PHONE;
    }

    public String getAGE_INDICIA() {
        return AGE_INDICIA;
    }

    public void setAGE_INDICIA(String aGE_INDICIA) {
        AGE_INDICIA = aGE_INDICIA;
    }

    public String getAGE_ADDR() {
        return AGE_ADDR;
    }

    public void setAGE_ADDR(String aGE_ADDR) {
        AGE_ADDR = aGE_ADDR;
    }

    public String getISREALNAME() {
        return ISREALNAME;
    }

    public void setISREALNAME(String iSREALNAME) {
        ISREALNAME = iSREALNAME;
    }

    public String getAUTHLEVEL() {
        return AUTHLEVEL;
    }

    public void setAUTHLEVEL(String AUTHLEVEL) {
        this.AUTHLEVEL = AUTHLEVEL;
    }

    public String getHideRealname() {
/*		if (!TextUtils.isEmpty(USER_NAME)) {
            return USER_NAME.substring(0, 1) + "**";
		}*/
        return USER_NAME;
    }

    public String getHideMobile() {
        if (!TextUtils.isEmpty(USER_MOBILE) && USER_MOBILE.length() > 5) {
            return USER_MOBILE.substring(0, 3) + "*****" + USER_MOBILE.substring(USER_MOBILE.length() - 3, USER_MOBILE.length());
        }
        return USER_MOBILE;
    }

    public String getWXUSERID() {
        return WXUSERID;
    }

    public void setWXUSERID(String WXUSERID) {
        this.WXUSERID = WXUSERID;
    }

    public String getWXUSERNAME() {
        return WXUSERNAME;
    }

    public void setWXUSERNAME(String WXUSERNAME) {
        this.WXUSERNAME = WXUSERNAME;
    }

    public String getWXUSERIMG() {
        return WXUSERIMG;
    }

    public void setWXUSERIMG(String WXUSERIMG) {
        this.WXUSERIMG = WXUSERIMG;
    }

    public String getINC_ADDR() {
        return INC_ADDR;
    }

    public void setINC_ADDR(String INC_ADDR) {
        this.INC_ADDR = INC_ADDR;
    }

    public String getINC_CARDTYPE() {
        return INC_CARDTYPE;
    }

    public void setINC_CARDTYPE(String INC_CARDTYPE) {
        this.INC_CARDTYPE = INC_CARDTYPE;
    }

    public String getINC_DEPUTY_MOBILE() {
        return INC_DEPUTY_MOBILE;
    }

    public void setINC_DEPUTY_MOBILE(String INC_DEPUTY_MOBILE) {
        this.INC_DEPUTY_MOBILE = INC_DEPUTY_MOBILE;
    }

    public String getPRJ_NAME() {
        return PRJ_NAME;
    }

    public void setPRJ_NAME(String PRJ_NAME) {
        this.PRJ_NAME = PRJ_NAME;
    }
}
