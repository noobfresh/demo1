package com.example.administrator.demo1.presenter;

import java.util.List;

/**
 * Created by Administrator on 2017/12/29.
 */

public interface IBasePresenter<T> {

    void refresh();

    List<T> display();
}
