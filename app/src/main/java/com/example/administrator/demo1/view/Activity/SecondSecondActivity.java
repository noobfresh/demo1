package com.example.administrator.demo1.view.Activity;

import android.content.Intent;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.demo1.R;
import com.example.administrator.demo1.model.entity.tree.TreeNode;
import com.example.administrator.demo1.util.BadgeUtil;

import java.util.Map;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class SecondSecondActivity extends AppCompatActivity implements View.OnClickListener{

    //携带数据回去，退出当前活动时，把红点数据带回去，并修改界面
    private Intent intent = new Intent();

    private Map<Integer, TreeNode> treeNodes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_second);
        int id = getIntent().getIntExtra("add", -1);
        TreeNode root = TreeNode.getSpecificTreeNode(id);
        treeNodes = BadgeUtil.initTreeNodeMap(R.id.linearSecondSecond, R.id.linearSecondSecond6,
                this, root, this, this.getWindow().getDecorView());
    }

    @Override
    public void onClick(View v) {
        TreeNode node = treeNodes.get(v.getId());
        node.setValue(0);
        updateBadge(v.getId());
        setResult(RESULT_OK, intent);
    }

    public void updateBadge(final int id){
        BadgeUtil.updateUI(this, id, treeNodes);
    }

}
