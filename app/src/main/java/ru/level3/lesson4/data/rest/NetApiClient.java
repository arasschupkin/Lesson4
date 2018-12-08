package ru.level3.lesson4.data.rest;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.level3.lesson4.data.Endpoints;
import ru.level3.lesson4.data.model.GithubUser;
import ru.level3.lesson4.data.model.ReposModel;

public class NetApiClient {

    private static final NetApiClient ourInstance = new NetApiClient();

    public static NetApiClient getInstance() {
        return ourInstance;
    }

    private Endpoints netApi = new ServiceGenerator().createService(Endpoints.class);

    private NetApiClient() {
    }

    public Observable<GithubUser> getUser(String user) {
        return netApi.getUser(user)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    public Flowable<List<ReposModel>> getRepos(String user) {
        return netApi.getRepos(user)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

}
