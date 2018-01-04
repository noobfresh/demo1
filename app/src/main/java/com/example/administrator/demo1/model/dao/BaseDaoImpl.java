package com.example.administrator.demo1.model.dao;

import com.example.administrator.demo1.util.DBUtil;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/4.
 */

public abstract class BaseDaoImpl<T> implements IBaseDao<T>{

    public BaseDaoImpl() {
        super();
    }

    @Override
    public void update(int id, T t) {
        DBUtil.updateById(t, id);
    }

    @Override
    public void insert(T t) {
        DBUtil.insert(t);
    }

//    @Override
//    public void delete(int id) {
//        Class <T> entityClass = (Class <T>) ((ParameterizedType)
//                getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//        DBUtil.deleteById(entityClass.getSimpleName(), id);
//    }
//
//    @Override
//    public List<T> query(String whereClause, String... args) {
//        Class <T> entityClass = (Class <T>) ((ParameterizedType)
//                getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//        List<T> list;
//        list = DBUtil.queryT(entityClass, whereClause, args);
//        return list;
//    }
}
