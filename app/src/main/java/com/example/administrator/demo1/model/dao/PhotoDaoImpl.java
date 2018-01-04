package com.example.administrator.demo1.model.dao;

import com.example.administrator.demo1.model.entity.Photo;
import com.example.administrator.demo1.util.DBUtil;
import com.example.administrator.demo1.view.Fragment.PhotoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/22.
 */

public class PhotoDaoImpl extends BaseDaoImpl<Photo> implements IPhotoDao {
    @Override
    public List<Photo> query(String whereClause, String... args) {
        List<Photo> photoList = new ArrayList<>();
        photoList = DBUtil.queryT(Photo.class, whereClause, args);
        return photoList;
    }

    @Override
    public void delete(int id) {
        DBUtil.deleteById("Photo", id);
    }

    @Override
    public void fasten(PhotoFragment fragment, List<Photo> photoList) {
        DBUtil.fastenLoadingPhoto(fragment, photoList, Photo.class, null);
    }
}
