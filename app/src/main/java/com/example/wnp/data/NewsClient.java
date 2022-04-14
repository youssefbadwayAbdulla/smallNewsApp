package com.example.wnp.data;

import com.example.wnp.pojo.NewsResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsClient {

    //https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=70bb926a044d4c7aa08668f5ff7c114e

    //baseUrl:https://newsapi.org/.....

    private static final String BASE_URL = "https://newsapi.org/";
    private static Retrofit retrofit;
    private NewsInterface newsInterface;

    public static NewsInterface getInstance() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
        }
        return retrofit.create(NewsInterface.class);
    }

    public Observable<NewsResponse> getNews() {
        return getInstance().getNews("eg","sport");
    }

}
