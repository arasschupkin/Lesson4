package ru.level3.lesson4.data;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.level3.lesson4.data.model.GithubUser;
import ru.level3.lesson4.data.model.ReposModel;

public interface Endpoints {

    @GET("/users/{user}")
    Observable<GithubUser> getUser(@Path("user") String user);

    @GET("/users/{user}/repos")
    Flowable<List<ReposModel>> getRepos(@Path("user") String user);

}
