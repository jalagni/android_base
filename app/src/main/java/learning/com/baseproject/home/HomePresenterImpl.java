package learning.com.baseproject.home;

import android.content.Context;

import learning.com.baseproject.appModel.ContentModel;
import learning.com.baseproject.network.HttpRequest;
import learning.com.baseproject.utils.AppUtils;

/**
 * Created by mohankumar on 7/14/18.
 */

public class HomePresenterImpl implements HttpRequest.HttpCallBack {

    private HomePresenter hPresent;
    private Context context;
    private HttpRequest hRequest;

    public HomePresenterImpl(Context context, HomePresenter hPrsnt){
        this.context = context;
        this.hPresent = hPrsnt;
        this.hRequest = new HttpRequest(context,this);
    }


    public void homeAction(){
        hRequest.getUser("1");
    }

    @Override
    public void onSuccess(Object obj) {
        if (obj == null || !(obj instanceof ContentModel)){
            hPresent.showDisplay("Error Response");
            return;
        }

        ContentModel cModel = (ContentModel) obj;
        hPresent.showContent(cModel);

    }

    @Override
    public void onFailure(Object obj) {
        hPresent.showDisplay(obj.toString());

    }


    interface HomePresenter{
        void showContent(ContentModel cModel);
        void showDisplay(String sMsg);
    }
}
