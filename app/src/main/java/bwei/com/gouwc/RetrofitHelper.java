package bwei.com.gouwc;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DangByMySide on 2017/12/19.
 */

public class RetrofitHelper {
    private   static OkHttpClient client;
    private   static ServiceAPI serviceAPI;

    static {
        getClient();
    }
    public static OkHttpClient getClient(){
        if(client==null){
            synchronized (OkHttpClient.class){
                if(client==null){
                    client=new OkHttpClient();
                }
            }
        }
        return client;
    }

    public static ServiceAPI getServiceAPI(){
        if(serviceAPI==null){
            synchronized (ServiceAPI.class){
                if(serviceAPI==null){
                    serviceAPI=onCreate(ServiceAPI.class,Api.HOST);
                }
            }
        }
        return serviceAPI;
    }


    public static  <T> T onCreate(Class<T> tclass, String url){

        Retrofit build = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        return build.create(tclass);
    }
}
