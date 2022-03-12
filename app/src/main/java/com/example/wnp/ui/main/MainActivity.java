package com.example.wnp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.example.wnp.R;
import com.example.wnp.databinding.ActivityMainBinding;
import com.example.wnp.pojo.NewsResponse;

import java.util.List;

public class MainActivity extends AppCompatActivity {
NewsViewModel  newsViewModel;
ActivityMainBinding binding;
NewsAdapter newsAdapter;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        newsViewModel= ViewModelProviders.of(this).get(NewsViewModel.class);
        newsViewModel.getNews();
        newsAdapter=new NewsAdapter();
        binding.rcViewNews.setAdapter(newsAdapter);
        newsViewModel.mutableLiveData.observe(this, new Observer<NewsResponse>() {
            @Override
            public void onChanged(NewsResponse newsResponses) {

                newsAdapter.setList(newsResponses.getArticles());
                Log.i(TAG, "onChanged: "+newsResponses.getArticles());

            }
        });
    }
}