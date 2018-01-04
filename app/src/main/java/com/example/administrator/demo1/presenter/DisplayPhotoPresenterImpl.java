package com.example.administrator.demo1.presenter;

import com.example.administrator.demo1.model.dao.IPhotoDao;
import com.example.administrator.demo1.model.dao.PhotoDaoImpl;
import com.example.administrator.demo1.model.entity.Photo;
import com.example.administrator.demo1.view.Activity.MainActivity;
import com.example.administrator.demo1.view.Fragment.PhotoFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/12/22.
 */

public class DisplayPhotoPresenterImpl extends BasePresenterImpl<Photo> implements IDisplayPhotoPresenter {

    private IPhotoDao photoDao;


    public DisplayPhotoPresenterImpl() {
        photoDao = new PhotoDaoImpl();
    }


    @Override
    public List<Photo> display() {
        List<Photo> photoList;
        photoList = photoDao.query(null);
        return photoList;
    }

    @Override
    public void fastenDisplay(PhotoFragment fragment, List<Photo> photoList) {
        photoDao.fasten(fragment, photoList);
    }


}
