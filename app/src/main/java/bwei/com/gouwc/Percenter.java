package bwei.com.gouwc;

import retrofit2.Call;

/**
 * Created by Yw_Ambition on 2017/12/21.
 */

public class Percenter {
    private IMainActivity iMainActivity;
    private final Model model;

    public Percenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        model = new Model();
    }
    public void showget(){
        model.doget("android", 1477, new OnNetListener<JavaBean>() {
            @Override
            public void Success(JavaBean javaBean) {
                iMainActivity.showBeans(javaBean);
            }

            @Override
            public void Failure(Call<JavaBean> call) {

            }
        });
    }

}
