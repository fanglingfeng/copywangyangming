package webhall.tyky.com.wangyangming.network.post;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by lenovo on 2017/1/6.
 */

public class NetWork {
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static Converter.Factory simpleXmlConverterFactory = SimpleXmlConverterFactory.create();
    private static Converter.Factory scalarsConverterFactory = ScalarsConverterFactory.create();

    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static RxJava2CallAdapterFactory rxJavaCallAdapterFactory = RxJava2CallAdapterFactory.create();

//    private static ZhengWuApi zhengWuApi;
//    private static ZhengWuApi zhengWuDOMAINApi;
//    private static ZhengWuApi zhengWuAchieveApi;
//    private static SenseTimeApi senseTimeApi;
//    private static PushApi pushApi;
//    private static LoginApi loginApi;
//    private static DownloadApi downloadApi;
//    private static FaceLoginApi faceLoginApi;
//    private static UserDataSource userDataApi;
//    private static WeatherApi weatherApi;
//    private static CollectPrintApi collectPrintApi;

    private static final int DEFAULT_TIMEOUT = 30;


    /**
     * 政务模块api
     *
     * @return
     */
//    public static CollectPrintApi getCollectPrintApi() {
//        if (collectPrintApi == null) {
//            Retrofit retrofit = new Retrofit.Builder()
//                    .client(getOkHttpClient())
//                    .baseUrl(UrlConstants.COLLECT_PRINT_CENTER)
//                    .addConverterFactory(gsonConverterFactory)
//                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
//                    .build();
//            collectPrintApi = retrofit.create(CollectPrintApi.class);
//        }
//        return collectPrintApi;
//    }
//
//    /**
//     * 政务模块api
//     *
//     * @return
//     */
//    public static ZhengWuApi getZhengWuCrossServerApi() {
//        if (zhengWuApi == null) {
//            Retrofit retrofit = new Retrofit.Builder()
//                    .client(getOkHttpClient())
//                    .baseUrl(UrlConstants.CROSS_SERVER_URL)
//                    .addConverterFactory(gsonConverterFactory)
//                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
//                    .build();
//            zhengWuApi = retrofit.create(ZhengWuApi.class);
//        }
//        return zhengWuApi;
//    }
//
//    public static ZhengWuApi getZhengWuCrossServerApi_hubei() {
//        if (zhengWuApi == null) {
//            Retrofit retrofit = new Retrofit.Builder()
//                    .client(getOkHttpClient())
//                    .baseUrl("192.168.0.116:8080/")
//                    .addConverterFactory(gsonConverterFactory)
//                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
//                    .build();
//            zhengWuApi = retrofit.create(ZhengWuApi.class);
//        }
//        return zhengWuApi;
//    }
//
//    /**
//     * 政务模块api【DOMAIN】
//     *
//     * @return
//     */
//    public static ZhengWuApi getZhengWuDOMAINApi() {
//        if (zhengWuDOMAINApi == null) {
//            Retrofit retrofit = new Retrofit.Builder()
//                    .client(getOkHttpClient())
//                    .baseUrl(UrlConstants.DOMAIN)
//                    .addConverterFactory(gsonConverterFactory)
//                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
//                    .build();
//            zhengWuDOMAINApi = retrofit.create(ZhengWuApi.class);
//        }
//        return zhengWuDOMAINApi;
//    }
//
//    public static UserDataSource getUserCrossServerApi() {
//        if (userDataApi == null) {
//            Retrofit retrofit = new Retrofit.Builder()
//                    .client(getOkHttpClient())
//                    .baseUrl(UrlConstants.CROSS_SERVER_URL)
//                    .addConverterFactory(gsonConverterFactory)
//                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
//                    .build();
//            userDataApi = retrofit.create(UserDataSource.class);
//        }
//        return userDataApi;
//    }
//
//    /**
//     * 推送模块api
//     *
//     * @return
//     */
//    public static PushApi getPushApi() {
//        if (pushApi == null) {
//            Retrofit retrofit = new Retrofit.Builder()
//                    .client(getOkHttpClient())
//                    .baseUrl(UrlConstants.PUSH_HOST)
//                    .addConverterFactory(gsonConverterFactory)
//                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
//                    .build();
//            pushApi = retrofit.create(PushApi.class);
//        }
//        return pushApi;
//    }
//
//    //贵州登录api
//    public static LoginApi getLoginApi_guizhou() {
//        if (loginApi == null) {
//            Retrofit retrofit = new Retrofit.Builder()
//                    .client(getOkHttpClient())
//                    .baseUrl("http://58.16.65.68:83/")
//                    .addConverterFactory(gsonConverterFactory)
//                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
//                    .build();
//            loginApi = retrofit.create(LoginApi.class);
//        }
//        return loginApi;
//    }
//
//    public static DownloadApi getDownloadApi(final ProgressResponseBody.ProgressListener progressListener) {
//        if (downloadApi == null) {
//            Retrofit retrofit = new Retrofit.Builder()
//                    .client(getDownloadOkHttpClient(progressListener))
//                    .baseUrl(UrlConstants.VERSON_BASE)
//                    .addConverterFactory(gsonConverterFactory)
//                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
//                    .build();
//            downloadApi = retrofit.create(DownloadApi.class);
//        }
//        return downloadApi;
//    }
//    public static FaceLoginApi getFaceLoginApi() {
//        if (faceLoginApi == null) {
//            Retrofit retrofit = new Retrofit.Builder()
//                    .client(getOkHttpClient())
//                    .baseUrl("http://42.123.101.116:81/api/")
//                    .addConverterFactory(gsonConverterFactory)
//                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
//                    .build();
//            faceLoginApi = retrofit.create(FaceLoginApi.class);
//        }
//        return faceLoginApi;
//    }
//
//    public static WeatherApi getWeatherApi() {
//        if (weatherApi == null) {
//            GsonBuilder gsonBuilder = new GsonBuilder();
//            Gson gson = gsonBuilder.setLenient().create();
//            Retrofit retrofit = new Retrofit.Builder()
//                    .client(getOkHttpClient())
//                    .baseUrl(UrlConstants.BASE_WEATHER_URL)
//                    .addConverterFactory(GsonConverterFactory.create(gson))
//                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
//                    .build();
//            weatherApi = retrofit.create(WeatherApi.class);
//        }
//        return weatherApi;
//    }
//
//    /**
//     * 政务模块api
//     *
//     * @return
//     */
//    public static ZhengWuApi getZhengWuAchieveNumServerApi() {
//        if (zhengWuAchieveApi == null) {
//            Retrofit retrofit = new Retrofit.Builder()
//                    .client(getOkHttpClient())
//                    .baseUrl(UrlConstants.AchieveNumUrl)
//                    .addConverterFactory(scalarsConverterFactory)
//                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
//                    .build();
//            zhengWuAchieveApi = retrofit.create(ZhengWuApi.class);
//        }
//        return zhengWuAchieveApi;
//    }
//
//
//    /**
//     * senseTime活脸认证api
//     *
//     * @return
//     */
//    public static SenseTimeApi getSenseTimeApi() {
//        if (senseTimeApi == null) {
//            Retrofit retrofit = new Retrofit.Builder()
//                    .client(getSenseTimeHttpClient())
//                    .baseUrl("https://v2-auth-api.visioncloudapi.com/")
//                    .addConverterFactory(gsonConverterFactory)
//                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
//                    .build();
//            senseTimeApi = retrofit.create(SenseTimeApi.class);
//        }
//        return senseTimeApi;
//    }
//
//    private static OkHttpClient getOkHttpClient() {
//
//        //新建log拦截器
//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//            @Override
//            public void log(String message) {
//                //打印retrofit日志
//                KLog.e("RetrofitLog", "OkHttp = " + message);
//            }
//        });
//
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        Interceptor interceptor = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Response response = chain.proceed(chain.request());  //如果401了，会先执行TokenAuthenticator
//                if (response.code() == 401) {
//                    LoginUtils.startLoginActivity();
//                }
//                return response;
//            }
//        };
//
//        //定制OkHttp
//        OkHttpClient client = null;
//        OkHttpClient.Builder builder = new OkHttpClient.Builder()
//                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//                .addInterceptor(interceptor);
//        if (BuildConfig.DEBUG) {
//            //上传文件时，拦截器setLevel(HttpLoggingInterceptor.Level.BODY)会多读一次body，使进度多写一次
//            client = builder.addInterceptor(loggingInterceptor)
//                    .build();
//        } else {
//            client = builder.build();
//        }
//        return client;
//    }
//
//    private static OkHttpClient getDownloadOkHttpClient(final ProgressResponseBody.ProgressListener progressListener) {
//        Interceptor interceptor = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Response originalResponse = chain.proceed(chain.request());
//                return originalResponse.newBuilder()
//                        .body(new ProgressResponseBody(originalResponse.body(), progressListener))
//                        .build();
//            }
//        };
//
//        OkHttpClient downloadOkHttpClient = new OkHttpClient.Builder()
//                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//                .addInterceptor(interceptor)
//                .build();
//        return downloadOkHttpClient;
//    }
//
//    public static OkHttpClient getSenseTimeHttpClient() {
//        Interceptor interceptor = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                Request.Builder builder1 = request.newBuilder();
//                Request build = builder1.addHeader("Authorization", AuthorizationGenUtils.getAuthoriztionStr()).build();
//                return chain.proceed(build);
//            }
//        };
//        //定制OkHttp
//        OkHttpClient client = new OkHttpClient.Builder()
//                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//                .addInterceptor(interceptor)
//                .build();
//        return client;
//    }
}
