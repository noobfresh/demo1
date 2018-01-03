package com.example.administrator.demo1.view.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.demo1.R;
import com.example.administrator.demo1.model.entity.Photo;
import com.example.administrator.demo1.presenter.DisplayPhotoPresenterImpl;
import com.example.administrator.demo1.presenter.IDisplayPhotoPresenter;
import com.example.administrator.demo1.view.Activity.MainActivity;
import com.example.administrator.demo1.view.PhotoAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 */

public class PhotoFragment extends Fragment {

    private List<Photo> photoList = new ArrayList<>();
    private IDisplayPhotoPresenter photoPresenter;
    RecyclerView recyclerView;

    public static final String TAG = "PhotoFragment";

    //已加载记录的数目
    private int recordCount = 0;
    PhotoAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        long startTime=System.currentTimeMillis();   //获取开始时间


        View view = inflater.inflate(R.layout.fragment_photo, container, false);
        recyclerView = view.findViewById(R.id.recyclerviewPhoto);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        photoPresenter = new DisplayPhotoPresenterImpl((MainActivity)getActivity());
//        photoList = photoPresenter.display();

        photoPresenter.fastenDisplay(this, photoList);
        long endTime=System.currentTimeMillis(); //获取结束时间
        Log.d(TAG, "onCreateView: time = " + (endTime - startTime));
        return view;
    }

    public void showPartofResult(final int count){
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(recordCount == 0){
                    adapter = new PhotoAdapter(photoList);
                    recyclerView.setAdapter(adapter);
                    recordCount = count;
                }else {
                    //出现问题Inconsistency detected
                    adapter.notifyItemRangeInserted(recordCount, count-recordCount);
                }

            }
        });
    }
}
