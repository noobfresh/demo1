package com.example.administrator.demo1.view.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.administrator.demo1.R;
import com.example.administrator.demo1.model.entity.News;
import com.example.administrator.demo1.presenter.DisplayNewsPresenterImpl;
import com.example.administrator.demo1.presenter.IDisplayNewsPresenter;
import com.example.administrator.demo1.util.HttpUtil;
import com.example.administrator.demo1.view.Activity.MainActivity;
import com.example.administrator.demo1.view.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 */

public class NewsFragment extends Fragment {

    private IDisplayNewsPresenter newsPresenter;

    private List<News> newsList = new ArrayList<>();

    private ProgressBar progressBar;

    private RecyclerView recyclerViewNews;

    public static final String TAG = "NewsFragment";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        newsPresenter = new DisplayNewsPresenterImpl((MainActivity)getActivity());
//        newsList = newsPresenter.display();
        recyclerViewNews = view.findViewById(R.id.recyclerviewNews);
        progressBar = view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext());
        recyclerViewNews.setLayoutManager(layoutManager2);
//        NewsAdapter adapter2 = new NewsAdapter(newsList);
//        recyclerViewNews.setAdapter(adapter2);
        HttpUtil.requestForNews(newsList, this);
        return view;
    }

    public void showResponse(){
        this.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                NewsAdapter adapter = new NewsAdapter(newsList);
                recyclerViewNews.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
            }
        });
    }


}
