package com.example.wnp.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wnp.data.NewsClient;
import com.example.wnp.pojo.NewsResponse;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NewsViewModel extends ViewModel {
    NewsClient newsClient=new NewsClient();
    private static final String TAG = "NewsViewModel";
    MutableLiveData<NewsResponse> mutableLiveData = new MutableLiveData<>();

    public void getNews() {
        Observable<NewsResponse> single =newsClient.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        single.subscribe(new Observer<NewsResponse>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull NewsResponse newsResponses) {
                mutableLiveData.setValue(newsResponses);
                Log.i(TAG, "onNext: "+newsResponses.toString());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i(TAG, "onError: "+e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete: ");
            }
        });


    }
}
