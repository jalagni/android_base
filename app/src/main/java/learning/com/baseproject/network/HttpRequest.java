package learning.com.baseproject.network;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.ProgressBar;

import learning.com.baseproject.R;
import learning.com.baseproject.appModel.ContentModel;
import learning.com.baseproject.utils.AppUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by mohankumar on 8/4/17.
 */

public class HttpRequest implements Callback {

    private Context context;
    private HttpCallBack hCallBack;
    private HttpService hService;
    private ProgressDialog dialog;

    public HttpRequest(Context context, HttpCallBack hCallBack){
        Retrofit retrofit = AppUtils.getRetrofit();
        this.context = context;
        this.hService = retrofit.create(HttpService.class);
        this.hCallBack = hCallBack;

        dialog = new ProgressDialog(context);
        dialog.setMessage(context.getString(R.string.loading));
    }

    public void getUser(String postId){
        Call call = hService.getUserDetail(postId);
        processRequest(call);
    }

    private void processRequest(Call call){
        dialog.show();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call call, Response response) {
        hCallBack.onSuccess(response.body());
        dialog.dismiss();
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        hCallBack.onFailure(t.toString());
        dialog.dismiss();
    }

    public interface HttpCallBack{
        void onSuccess(Object obj);
        void onFailure(Object obj);
    }

    interface HttpService{
        @GET("posts/{postId}")
        Call<ContentModel> getUserDetail(@Path("postId") String pId);

    }


}
