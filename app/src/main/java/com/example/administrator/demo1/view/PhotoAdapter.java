package com.example.administrator.demo1.view;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.demo1.R;
import com.example.administrator.demo1.model.entity.Photo;
import com.example.administrator.demo1.util.DBUtil;
import com.example.administrator.demo1.view.Activity.MainActivity;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {


    public static final String TAG = "PhotoAdapter";


    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.photoImage);
            textView = itemView.findViewById(R.id.photoTitle);
        }
    }

    private List<Photo> photoList;

    public PhotoAdapter(List<Photo> photoList) {
        this.photoList = photoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Photo photo = photoList.get(position);
        holder.imageView.setImageResource(photo.getPhotoId());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity)v.getContext();
                TextView textView = holder.textView;
                textView.setTextColor(Color.BLUE);
                photo.setIsRead(true);
                DBUtil.updateById(photo, photo.getId());
                mainActivity.updateBadgeView();
            }
        });
        Log.d(TAG, "onBindViewHolder: " + holder.hashCode());
        holder.textView.setText(photo.getDescription());
        if(photo.getIsRead() == true){
            holder.textView.setTextColor(Color.BLUE);
        }else {
            holder.textView.setTextColor(Color.GRAY);
        }

    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }
}
