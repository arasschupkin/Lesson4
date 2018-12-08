package ru.level3.lesson4.presenter;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import ru.level3.lesson4.data.model.ReposModel;

public interface ReposView extends MvpView {

    void setRepos(List<ReposModel> repos);

    void showError(Throwable e);

    void startLoad();

    void finishLoad();
}


