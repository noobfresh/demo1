package com.example.administrator.demo1.view.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.demo1.R;
import com.example.administrator.demo1.model.entity.tree.TreeNode;
import com.example.administrator.demo1.util.BadgeUtil;
import com.example.administrator.demo1.view.Activity.FirstSettingActivity;
import com.example.administrator.demo1.view.Activity.MainActivity;
import com.example.administrator.demo1.view.Activity.SecondSettingActivity;

import java.util.Map;
import java.util.Set;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

/**
 * Created by Administrator on 2017/12/21.
 */

public class SettingFragment extends Fragment implements View.OnClickListener{

    public static final String TAG = "SettingFragment";

    private Map<Integer, TreeNode> treeNodes;


    private Intent intent = new Intent();

    private MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_setting, container, false);

        mainActivity = (MainActivity)getActivity();
        treeNodes = BadgeUtil.initTreeNodeMap(R.id.linear1, R.id.linear4,
                getActivity(), TreeNode.getmRoot(), this, view);
        return view;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.linear1:
                intent = new Intent(getContext(), SecondSettingActivity.class);
                intent.putExtra("add", treeNodes.get(v.getId()).getId());
                startActivityForResult(intent, 1);
                break;
            case R.id.linear3:
                intent = new Intent(getContext(), FirstSettingActivity.class);
                intent.putExtra("add", treeNodes.get(v.getId()).getId());
                startActivityForResult(intent, 2);
                break;
            default:
                TreeNode treeNode = treeNodes.get(v.getId());
                treeNode.setValue(0);
                updateBadgeView(v.getId());
                break;
        }
    }

    public void updateBadgeView(final int id){
//        getActivity().runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//
//                //更新下树的值
//            }
//        });
        BadgeUtil.updateUI(getActivity(), id, treeNodes);
        mainActivity.updateSettingBadge();
        //
    }

    public void updateSettingBadgeView(){
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Set<Integer> set = treeNodes.keySet();
                for (Integer id : set) {
                    TreeNode treeNode = treeNodes.get(id);
                    BadgeUtil.badgeSetForTextView(treeNode.getBadge(), treeNode.getValue());
                }
            }
        });
        mainActivity.updateSettingBadge();
    }


    //待修改
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == -1) {
            updateSettingBadgeView();
        }
    }

}
