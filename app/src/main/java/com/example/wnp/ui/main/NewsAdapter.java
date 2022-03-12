package com.example.wnp.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wnp.R;
import com.example.wnp.databinding.NewItemBinding;
import com.example.wnp.pojo.Article;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {
    List<Article> articles = new ArrayList<>();

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.new_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        Article article = articles.get(position);
        holder.binding.tvNews.setText(article.getTitle());
        Glide.with(holder.itemView)
                .load(article.getUrlToImage()).placeholder(R.mipmap.ic_launcher).into(holder.binding.ivNews);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public void setList(List<Article>articles){
        this.articles=articles;
        notifyDataSetChanged();
    }

    class NewsHolder extends RecyclerView.ViewHolder {
        NewItemBinding binding;

        public NewsHolder(@NonNull NewItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
