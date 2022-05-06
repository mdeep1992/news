package Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import response.Articleresponse;
import retrofit.ApiRequest;
import retrofit.RetrofitRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepository {
    private static final String TAG= ArticleRepository.class.getSimpleName();
    private final ApiRequest apiRequest;
public ArticleRepository(){
        apiRequest= RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }
    public LiveData<Articleresponse> getDashboardNews(){
    final MutableLiveData<Articleresponse>data=new MutableLiveData<>();
    apiRequest.getTopHeadlines()
            .enqueue(new Callback<Articleresponse>() {
                @Override
                public void onResponse(Call<Articleresponse> call, Response<Articleresponse> response) {
                    if (response.body()!=null){
                        data.setValue(response.body());
                    }

                }

                @Override
                public void onFailure(Call<Articleresponse> call, Throwable t) {
                    data.setValue(null);

                }
            });
    return data;
    }
}
