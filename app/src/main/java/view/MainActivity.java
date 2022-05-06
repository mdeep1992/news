package view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.newsapp.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.ArticleAdapter;
import model.Article;
import view_model.Articleviewmodel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG=(MainActivity.class.getSimpleName());
    private RecyclerView recycler_View;
    private ProgressBar progress_bar;
    private LinearLayoutManager layoutManager;
    private ArticleAdapter adapter;
    private ArrayList<Article>articleArrayList=new ArrayList<>();
    Articleviewmodel articleviewmodel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getArticles();
    }

    private void getArticles() {
     articleviewmodel.getBashBoardNewsResponseLiveData().observe(this,articleresponse ->{
         if (articleresponse!=null&&articleresponse.getArticles()!=null
                 &&!articleresponse.getArticles().isEmpty());
         progress_bar.setVisibility(View.GONE);
         List<Article>articleList=articleresponse.getArticles();
         articleArrayList.addAll(articleList);
         adapter.notifyDataSetChanged();
     });



    };

    private void init() {
        recycler_View=findViewById(R.id.recycler_view);
        progress_bar=findViewById(R.id.progress_bar);
        layoutManager=new LinearLayoutManager(MainActivity.this);
        recycler_View.setLayoutManager(layoutManager);
        recycler_View.setHasFixedSize(true);
        adapter=new ArticleAdapter(MainActivity.this,articleArrayList);
        recycler_View.setAdapter(adapter);
        articleviewmodel= ViewModelProviders.of(this).get(Articleviewmodel.class);
    }
}