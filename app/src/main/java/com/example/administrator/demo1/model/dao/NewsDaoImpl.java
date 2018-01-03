package com.example.administrator.demo1.model.dao;

import com.example.administrator.demo1.model.entity.News;
import com.example.administrator.demo1.util.DBUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/22.
 */

public class NewsDaoImpl implements INewsDao {
    @Override
    public List<News> query(String whereClause, String... args) {
        List<News> newsList = new ArrayList<>();
        newsList = DBUtil.queryT(News.class, whereClause, args);
        return newsList;
    }

    @Override
    public void insert(News news) {
        DBUtil.insert(news);
    }

    @Override
    public void delete(int id) {
        DBUtil.deleteById("News", id);
    }

    @Override
    public void update(int id, News news) {
        DBUtil.updateById(news, id);
    }
}
