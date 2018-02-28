package webhall.tyky.com.wangyangming.network.soap;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

/**
 * Created by dengyibin on 2017/8/24.
 *
 * @description
 */

public class SoapParams implements Builder<JsonObject> {
    private JsonObject object;

    public SoapParams() {
        object = new JsonObject();
    }
    public SoapParams token(){
//        object.addProperty("token", AccountHelper.isLogin()?AccountHelper.getUser().getTOKEN():"");
        return this;
    }
    public SoapParams token(String token){
        object.addProperty("token",token);
        return this;
    }
    public SoapParams pageSize(int PAGESIZE){
        object.addProperty("PAGESIZE",String.valueOf(PAGESIZE));
        return this;
    }
    public SoapParams pageNo(int PAGENO){
        object.addProperty("PAGENO",String.valueOf(PAGENO));
        return this;
    }

    public SoapParams add(String property, JsonElement value) {
        if (value == null) {
            value = JsonNull.INSTANCE;
        }
        object.add(property, value);
        return this;
    }

    public SoapParams addProperty(String property, String value) {
        object.addProperty(property, value);
        return this;
    }

    public SoapParams addProperty(String property, Number value) {
        object.addProperty(property, value);
        return this;
    }

    public SoapParams addProperty(String property, Boolean value) {
        object.addProperty(property, value);
        return this;
    }

    public SoapParams addProperty(String property, Character value) {
        object.addProperty(property, value);
        return this;
    }

    @Override
    public JsonObject build() {
        return object;
    }
}

