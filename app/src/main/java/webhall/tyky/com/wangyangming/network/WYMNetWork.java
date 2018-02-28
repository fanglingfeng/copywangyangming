package webhall.tyky.com.wangyangming.network;

import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.socks.library.KLog;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import webhall.tyky.com.wangyangming.BuildConfig;
import webhall.tyky.com.wangyangming.base.ProgressResponseBody;
import webhall.tyky.com.wangyangming.constants.UrlConstants;
import webhall.tyky.com.wangyangming.network.api.LoginApi;
import webhall.tyky.com.wangyangming.network.api.WYMApi;

/**
 * Created by lenovo on 2017/1/6.
 */

public class WYMNetWork {

    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static Converter.Factory simpleXmlConverterFactory = SimpleXmlConverterFactory.create();
    private static Converter.Factory scalarsConverterFactory = ScalarsConverterFactory.create();

    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static RxJava2CallAdapterFactory rxJavaCallAdapterFactory = RxJava2CallAdapterFactory.create();


    private static final int DEFAULT_TIMEOUT = 60;
    private static LoginApi loginApi;
    private static WYMApi wymApi;



    /**
     * 登录 api
     * @return
     */
    public static LoginApi getLoginApi() {
        if (loginApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(getOkHttpClient())
                    .baseUrl(UrlConstants.LoginUrl)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            loginApi = retrofit.create(LoginApi.class);
        }
        return loginApi;
    }
 /**
     * 首页 api
     * @return
     */
    public static WYMApi getWymApi() {
        if (wymApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(getOkHttpClient())
                    .baseUrl(UrlConstants.wymUrl)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                            .setLenient()
                            .create()))
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            wymApi = retrofit.create(WYMApi.class);
        }
        return wymApi;
    }

    private static OkHttpClient getBaiduOkhttpClicent() {
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                //打印retrofit日志
                KLog.e("RetrofitLog","OkHttp = "+message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //定制OkHttp
        OkHttpClient client =  new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();
        return client;
    }

    private static OkHttpClient getOkHttpClient() {

        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                //打印retrofit日志
                KLog.e("RetrofitLog","OkHttp = "+message);
            }
        });

        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //定制OkHttp
        OkHttpClient client = null;
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        if(BuildConfig.DEBUG) {
            //上传文件时，拦截器setLevel(HttpLoggingInterceptor.Level.BODY)会多读一次body，使进度多写一次
            client = builder.addInterceptor(loggingInterceptor)
                    .build();
        }else {
            client = builder.build();
        }
        return client;
    }

    private static OkHttpClient getDownloadOkHttpClient(final ProgressResponseBody.ProgressListener progressListener){
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response originalResponse = chain.proceed(chain.request());
                return originalResponse.newBuilder()
                        .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                        .build();
            }
        };

        OkHttpClient downloadOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
        return downloadOkHttpClient;
    }
}
