package bwei.com.gouwc;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Yw_Ambition on 2017/12/21.
 */

public class Model {
    public void doget(String source, int uid, final OnNetListener<JavaBean> onNetListener){
        ServiceAPI serviceAPI = RetrofitHelper.getServiceAPI();
        Flowable<JavaBean> bean = serviceAPI.bean(source, uid);
        bean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<JavaBean>() {
                    @Override
                    public void accept(JavaBean javaBean) throws Exception {
                        onNetListener.Success(javaBean);
                    }
                });
    }
}
