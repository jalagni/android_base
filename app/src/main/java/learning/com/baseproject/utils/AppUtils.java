package learning.com.baseproject.utils;

import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mohankumar on 7/14/18.
 */

public class AppUtils {

    public static Retrofit getRetrofit(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConst.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;

    }

    public static void showMessage(View view,String sText){
        Snackbar.make(view,sText, Snackbar.LENGTH_SHORT).show();
    }

    public static void logError(String sError){
        Log.e(AppConst.TAG,sError);
    }

}
