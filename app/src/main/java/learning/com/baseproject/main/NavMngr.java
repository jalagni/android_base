package learning.com.baseproject.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import java.util.HashMap;

import learning.com.baseproject.R;
import learning.com.baseproject.base.BaseActivity;
import learning.com.baseproject.utils.AppUtils;

/**
 * Created by mohankumar on 7/14/18.
 */

public class NavMngr {

    private static NavMngr nMngr;
    public static NavMngr getInstance(){
        if(nMngr == null){
            nMngr = new NavMngr();
        }
        return nMngr;
    }

    private NavMngr(){}

    private HashMap hMap = new HashMap();
    private final String BASE_ACTIVITY = "default";

    public void registerActivity(BaseActivity bActivity){

        if(hMap.containsKey(BASE_ACTIVITY)){
            AppUtils.logError("activity already registered");
        }

        hMap.put(BASE_ACTIVITY,bActivity);
    }

    private BaseActivity getBaseActivity(){
        BaseActivity bActivity = (BaseActivity) hMap.get(BASE_ACTIVITY);
        return bActivity;
    }

    public void pushFragment(Fragment fragment){

        FragmentTransaction fTransact = getBaseActivity().getSupportFragmentManager().beginTransaction();
        fTransact.replace(R.id.iFrame, fragment);
        fTransact.addToBackStack(fragment.getClass().toString());
        fTransact.commit();
    }

}
