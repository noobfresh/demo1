package com.example.administrator.demo1.view;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.demo1.R;
import com.example.administrator.demo1.model.entity.News;
import com.example.administrator.demo1.util.DateFormatUtil;
import com.example.administrator.demo1.view.Activity.NewsActivity;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> newsList;



    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView newsTitle;
        TextView newsDate;
        TextView newsContent;
        String id;


        public ViewHolder(View itemView) {
            super(itemView);
            newsContent = itemView.findViewById(R.id.newsContent);
            newsDate = itemView.findViewById(R.id.newsDate);
            newsTitle = itemView.findViewById(R.id.newsTitle);
        }
    }

    public NewsAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.newsContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent.getContext(), NewsActivity.class);
                intent.putExtra("id", viewHolder.id);
                parent.getContext().startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.newsDate.setText(DateFormatUtil.displayDateFormat(news.getDate()));
        holder.newsTitle.setText(news.getTitle());
        holder.newsContent.setText(news.getContent());
        holder.id = news.getId();
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
