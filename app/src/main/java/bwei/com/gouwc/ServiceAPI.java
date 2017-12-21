package bwei.com.gouwc;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Yw_Ambition on 2017/12/21.
 */

public interface ServiceAPI {
    @GET(Api.URL)
    Flowable<JavaBean> bean(@Query("source") String source,@Query("uid") int uid);
}
