package learning.com.baseproject.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import learning.com.baseproject.R;
import learning.com.baseproject.base.BaseActivity;
import learning.com.baseproject.databinding.ActivityMainBinding;
import learning.com.baseproject.main.NavMngr;
import learning.com.baseproject.utils.AppUtils;

public class HomeActivity extends BaseActivity implements
        View.OnClickListener,MainPresenterImpl.MainPresenter {

    private ActivityMainBinding aBinding;
    private MainPresenterImpl mImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        setSupportActionBar(aBinding.toolbar);

        NavMngr.getInstance().registerActivity(this);
        initActivity();

    }


    private void initActivity(){
        mImpl = new MainPresenterImpl(this);
        aBinding.fab.setOnClickListener(this);

        NavMngr.getInstance().pushFragment(HomeFragment.newInstance());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.fab:
                AppUtils.showMessage(aBinding.getRoot(),
                        getString(R.string.action));
            break;
        }
    }

    @Override
    public void displayMessage() {

    }
}
