package learning.com.baseproject.home;

/**
 * Created by mohankumar on 7/14/18.
 */

public class MainPresenterImpl {

    private MainPresenter mImpl;

    public MainPresenterImpl(MainPresenter mPresent){
        this.mImpl = mPresent;
    }

    interface MainPresenter{
        void displayMessage();
    }
}
