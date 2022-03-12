package com.example.wnp.data;

import com.example.wnp.pojo.NewsResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsInterface {
    // endpoint:top-headlines?country=us&category=business&apiKey=70bb926a044d4c7aa08668f5ff7c114e
//    @GET("top-headlines?country=us&category=business&apiKey=70bb926a044d4c7aa08668f5ff7c114e")
//    Single<List<NewsResponse>> getNews();
    @GET("v2/top-headlines?apiKey=70bb926a044d4c7aa08668f5ff7c114e")
    Observable<NewsResponse> getNews(@Query("country")String country,
                                           @Query("category")String category);
}
