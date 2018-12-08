package ru.level3.lesson4.presenter;


import com.arellomobile.mvp.MvpView;

public interface UserView extends MvpView {
    void setName(String name);

    void setImage(String imageUrl);

    void showError(Throwable e);

    void startLoad();

    void finishLoad();
}
