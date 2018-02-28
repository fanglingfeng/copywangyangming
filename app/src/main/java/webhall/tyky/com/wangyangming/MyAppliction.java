package webhall.tyky.com.wangyangming;


import android.content.Context;
import android.content.res.Resources;
import android.support.multidex.MultiDex;
import android.util.TypedValue;

import com.dino.changeskin.SkinManager;
import com.dino.changeskin.utils.PrefUtils;
import com.facebook.stetho.Stetho;
import com.socks.library.KLog;
import com.taobao.sophix.PatchStatus;
import com.taobao.sophix.SophixManager;
import com.taobao.sophix.listener.PatchLoadStatusListener;
import com.tencent.bugly.beta.Beta;
import com.umeng.socialize.Config;
import com.umeng.socialize.UMShareAPI;

import net.liang.appbaselibrary.utils.AppUtils;
import net.liang.appbaselibrary.utils.SPUtils;
import net.liang.appbaselibrary.utils.ToastUtils;

import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ImageLoader;
import cn.finalteam.galleryfinal.ThemeConfig;
import cn.jpush.android.api.JPushInterface;
import webhall.tyky.com.wangyangming.data.AccountHelper;
import webhall.tyky.com.wangyangming.wights.UILImageLoader;


/**
 * Created by long on 2017/2/17.
 */

public class MyAppliction extends AppConfig {

    public static String FILTER_AREAID = "";//区级区域筛选

    @Override
    public void onCreate() {
        initJpush();
        initHotfix();

        super.onCreate();
        //友盟分享初始化
        Config.DEBUG = true;
        UMShareAPI.get(this);

        // 初始化账户基础信息
        AccountHelper.init(this);

        //初始化Toast
        ToastUtils.init(this);

        //换肤
        SkinManager.getInstance().init(this);

        //init Log
        KLog.init(BuildConfig.LOG_DEBUG);

        //初始化本地存储
        SPUtils.init(this);

        //初始化图片选择
        initImageSelector();

        initStetho();
    }
    /*初始化极光推送*/
    private void initJpush() {
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }

    private void initHotfix() {
        SophixManager.getInstance().setContext(this)
                .setAppVersion(AppUtils.getAppVersionName(this))
                .setAesKey(null)
                .setEnableDebug(true)
                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
                    @Override
                    public void onLoad(final int mode, final int code, final String info, final int handlePatchVersion) {
                        // 补丁加载回调通知
                        if (code == PatchStatus.CODE_LOAD_SUCCESS) {
                            // 表明补丁加载成功
                        } else if (code == PatchStatus.CODE_LOAD_RELAUNCH) {
                            // 表明新补丁生效需要重启. 开发者可提示用户或者强制重启;
                            // 建议: 用户可以监听进入后台事件, 然后应用自杀
                        } else if (code == PatchStatus.CODE_LOAD_FAIL) {
                            // 内部引擎异常, 推荐此时清空本地补丁, 防止失败补丁重复加载
                             SophixManager.getInstance().cleanPatches();
                        } else {
                            // 其它错误信息, 查看PatchStatus类说明
                        }
                    }
                }).initialize();
        SophixManager.getInstance().queryAndLoadNewPatch();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
        Beta.installTinker();
        Beta.canNotifyUserRestart = true;
    }

    private void initStetho() {
        //chrome://inspect/
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }

    private void initImageSelector() {
        //设置主题
        //ThemeConfig.CYAN

        TypedValue typedValue = new TypedValue();
        this.getTheme().resolveAttribute(android.R.attr.textColorPrimary, typedValue, true);
        int color = typedValue.resourceId;

        //针对换肤做的适配
        int titleBar;
        try{
            PrefUtils prefUtils = new PrefUtils(this);
            titleBar = getResources().getColor(getResources().getIdentifier("colorPrimary"+"_"+ prefUtils.getSuffix(),"color",getPackageName()));
        }catch (Resources.NotFoundException e){
            //一般是不会出现这个异常的，这里还是以防万一捕获下设一个固定值
            titleBar = getResources().getColor(R.color.colorPrimary);
        }
        ThemeConfig theme = new ThemeConfig.Builder()
                .setTitleBarIconColor(titleBar)
                .setTitleBarBgColor(getResources().getColor(R.color.toolbarBackColor))
                .setTitleBarTextColor(getResources().getColor(R.color.black))
//                .setTitleBarTextColor(getResources().getColor(color))
                .build();
        //配置功能
        FunctionConfig functionConfig = new FunctionConfig.Builder()
                .setEnableCamera(false)
                .setEnableEdit(true)
                .setEnableCrop(true)
                .setEnableRotate(true)
                .setCropSquare(true)
                .setEnablePreview(true)
                .build();

        //配置imageloader
        ImageLoader imageloader = new UILImageLoader();
        CoreConfig coreConfig = new CoreConfig.Builder(this, imageloader, theme)
//                .setDebug(BuildConfig.DEBUG)
                .setFunctionConfig(functionConfig)
//                .setNoAnimcation(true)
                .build();
        GalleryFinal.init(coreConfig);
    }
}
