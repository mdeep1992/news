package view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import Repository.ArticleRepository;
import response.Articleresponse;


public class Articleviewmodel extends AndroidViewModel {
    private ArticleRepository articleRepository;
    private LiveData<Articleresponse> articleResponseLiveData;

    public Articleviewmodel(@NonNull Application application ) {
        super(application);
        articleRepository =new  ArticleRepository();
        this.articleResponseLiveData = articleRepository.getDashboardNews();
    }
    public LiveData<Articleresponse>getBashBoardNewsResponseLiveData(){
        return articleResponseLiveData;
    }

}

