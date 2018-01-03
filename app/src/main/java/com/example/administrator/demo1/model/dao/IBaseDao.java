package com.example.administrator.demo1.model.dao;

import com.example.administrator.demo1.model.entity.Comment;

import java.util.List;

/**
 * Created by Administrator on 2017/12/29.
 */

public interface IBaseDao<T> {

    List<T> query(String whereClause, String... args);

    void insert(T t);

    void delete(int id);

    void update(int id, T t);
}
