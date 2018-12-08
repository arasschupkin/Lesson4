package ru.level3.lesson4.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import ru.level3.lesson4.data.model.ReposModel;
import ru.level3.lesson4.data.rest.NetApiClient;

@InjectViewState
public class ReposPresenter extends MvpPresenter<ReposView> implements Subscriber<List<ReposModel>> {

    @Override
    public void attachView(ReposView view) {
        super.attachView(view);
        getViewState().startLoad();
        loadData();
    }

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(List<ReposModel> data) {
        Log.d("Dto", "size = " + data.size());
        getViewState().setRepos(data);
    }

    @Override
    public void onComplete() {
        getViewState().finishLoad();
    }

    @Override
    public void onError(Throwable t) {
        getViewState().showError(t);
        getViewState().finishLoad();
    }

    private void loadData() {
        getViewState().startLoad();
        NetApiClient.getInstance().getRepos(("arasschupkin")).subscribe(this);
    }
}



