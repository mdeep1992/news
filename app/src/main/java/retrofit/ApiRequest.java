package retrofit;

import static constant.appconstant.API_KEY;

import response.Articleresponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {

    @GET("top-headlines?Country=in&category=entertainment&apikey="+API_KEY)
    Call<Articleresponse>getTopHeadlines();
}
