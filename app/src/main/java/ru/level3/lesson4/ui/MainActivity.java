package ru.level3.lesson4.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.squareup.picasso.Picasso;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.level3.lesson4.R;

import ru.level3.lesson4.data.model.ReposModel;
import ru.level3.lesson4.presenter.ReposPresenter;
import ru.level3.lesson4.presenter.ReposView;
import ru.level3.lesson4.presenter.UserPresenter;
import ru.level3.lesson4.presenter.UserView;

public class MainActivity extends MvpAppCompatActivity implements UserView, ReposView {

    @InjectPresenter
    UserPresenter presenter;

    @InjectPresenter
    ReposPresenter repsPresenter;

    @BindView(R.id.avatar) ImageView imageView;
    @BindView(R.id.userName) TextView nameView;
    @BindView(R.id.userRepos) TextView userReposView;
    @BindView(R.id.loadingView) ProgressBar progress;
    @BindView(R.id.contentView) View content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }


    @Override
    public void setImage(String imageUrl) {

        Picasso.get()
                .load(imageUrl)
                .into(imageView);
    }

    @Override
    public void setName(String name) {
        nameView.setText(name);
    }


    @Override
    public void setRepos(List<ReposModel> repos) {

        String s = "";
        for (int i=0;i<repos.size();i++){
            s += repos.get(i).full_name +"\n";
        }

        userReposView.setText(s);

    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        progress.setVisibility(View.GONE);
        content.setVisibility(View.GONE);
    }

    @Override
    public void startLoad() {
        progress.setVisibility(View.VISIBLE);
        content.setVisibility(View.GONE);
    }

    @Override
    public void finishLoad() {
        progress.setVisibility(View.GONE);
        content.setVisibility(View.VISIBLE);
    }

}
