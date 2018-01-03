package com.example.administrator.demo1.model.dao;

import com.example.administrator.demo1.model.entity.Photo;
import com.example.administrator.demo1.view.Fragment.PhotoFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 */

public interface IPhotoDao extends IBaseDao<Photo>{
    public void fasten(PhotoFragment fragment, List<Photo> photoList);
}
