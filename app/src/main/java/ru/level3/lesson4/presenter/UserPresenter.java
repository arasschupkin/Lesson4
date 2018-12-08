package ru.level3.lesson4.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import ru.level3.lesson4.data.model.GithubUser;
import ru.level3.lesson4.data.rest.NetApiClient;

@InjectViewState
public class UserPresenter extends MvpPresenter<UserView>
        implements Observer<GithubUser> {

    @Override
    public void attachView(UserView view) {
        super.attachView(view);
        loadDate();
    }

    private void loadDate() {
        getViewState().startLoad();
        NetApiClient.getInstance().getUser("arasschupkin")
                .subscribe(this);
    }

    @Override
    public void onSubscribe(Disposable d) {
        //nope
    }

    @Override
    public void onNext(GithubUser githubUser) {
        getViewState().setImage(githubUser.getAvatar());
        getViewState().setName(githubUser.getLogin());
    }

    @Override
    public void onError(Throwable e) {
        getViewState().showError(e);
    }

    @Override
    public void onComplete() {
        getViewState().finishLoad();
    }
}


