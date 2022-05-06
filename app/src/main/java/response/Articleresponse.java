package response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.Article;
public class Articleresponse {
    @SerializedName("articles")
    @Expose
    private List<Article>articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "BaseboardNewsResponse{"+
                "articles="+articles+'}';
    }
}
