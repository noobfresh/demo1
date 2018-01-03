package com.example.administrator.demo1.presenter;

import com.example.administrator.demo1.model.entity.Photo;
import com.example.administrator.demo1.view.Fragment.PhotoFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 */

public interface IDisplayPhotoPresenter extends IBasePresenter<Photo>{

    void fastenDisplay(PhotoFragment fragment, List<Photo> photoList);
}
