package bwei.com.gouwc;

import retrofit2.Call;

/**
 * Created by Yw_Ambition on 2017/12/21.
 */

public interface OnNetListener<T> {
    void Success(T t);
    void Failure(Call<T> call);
}
