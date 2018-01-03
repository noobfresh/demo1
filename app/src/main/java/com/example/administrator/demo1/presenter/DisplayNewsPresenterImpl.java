package com.example.administrator.demo1.presenter;

import com.example.administrator.demo1.model.dao.INewsDao;
import com.example.administrator.demo1.model.dao.NewsDaoImpl;
import com.example.administrator.demo1.model.entity.News;
import com.example.administrator.demo1.view.Activity.MainActivity;

import java.util.List;

/**
 * Created by Administrator on 2017/12/22.
 */

public class DisplayNewsPresenterImpl implements IDisplayNewsPresenter {

    private INewsDao newsDao;
    private MainActivity mainActivity;


    public DisplayNewsPresenterImpl(MainActivity mainActivity) {
        //暂时null
        this.mainActivity = null;
        newsDao = new NewsDaoImpl();
    }


    @Override
    public void refresh() {

    }

    @Override
    public List<News> display() {
        List<News> newsList = newsDao.query(null);
        return newsList;
    }
}
