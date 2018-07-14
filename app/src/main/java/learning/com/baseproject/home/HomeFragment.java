package learning.com.baseproject.home;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import learning.com.baseproject.R;
import learning.com.baseproject.appModel.ContentModel;
import learning.com.baseproject.databinding.FragHomeBinding;
import learning.com.baseproject.utils.AppUtils;

/**
 * Created by mohankumar on 7/14/18.
 */

public class HomeFragment extends Fragment implements
        HomePresenterImpl.HomePresenter, View.OnClickListener {


    private Activity activity;
    private FragHomeBinding fBinding;
    private HomePresenterImpl hImpl;

    public static HomeFragment newInstance(){
        HomeFragment hFrag = new HomeFragment();
        return hFrag;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(activity).inflate(R.layout.frag_home, null);
        fBinding = DataBindingUtil.bind(view);
        initView();
        return fBinding.getRoot();
    }


    private void initView(){
        hImpl = new HomePresenterImpl(getContext(),this);
        fBinding.btnAction.setOnClickListener(this);

    }

    @Override
    public void showContent(ContentModel cModel) {

        fBinding.tHead.setText(cModel.getTitle());
        fBinding.tBody.setText(cModel.getBody());
    }

    @Override
    public void showDisplay(String sMsg) {
        AppUtils.showMessage(fBinding.getRoot(),sMsg);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAction:
                hImpl.homeAction();
                break;
        }
    }
}
