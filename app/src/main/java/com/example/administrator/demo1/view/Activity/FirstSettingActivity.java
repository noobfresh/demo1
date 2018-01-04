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
import java.util.Set;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class FirstSettingActivity extends AppCompatActivity implements View.OnClickListener{

    private Intent intent = new Intent();
    private Intent intent1;

    private Map<Integer, TreeNode> treeNodes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_setting);
        int id = getIntent().getIntExtra("add", -1);
        TreeNode root = TreeNode.getSpecificTreeNode(id);
        treeNodes = BadgeUtil.initTreeNodeMap(R.id.linearSetting1, R.id.linearSetting6,
                this, root, this, this.getWindow().getDecorView());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //隐私
            case R.id.linearSetting3:
                intent1 = new Intent(FirstSettingActivity.this,
                        FirstFirstActivity.class);
                intent1.putExtra("add", treeNodes.get(v.getId()).getId());
                startActivityForResult(intent1,1);
                break;
            //账号
            case R.id.linearSetting5:
                intent1 = new Intent(FirstSettingActivity.this,
                        FirstSecondActivity.class);
                intent1.putExtra("add", treeNodes.get(v.getId()).getId());
                startActivityForResult(intent1,2);
                break;
            //新消息提醒
            case R.id.linearSetting1:
                intent1 = new Intent(FirstSettingActivity.this,
                        FirstThirdActivity.class);
                intent1.putExtra("add", treeNodes.get(v.getId()).getId());
                startActivityForResult(intent1,3);
                break;
            default:
                TreeNode node = treeNodes.get(v.getId());
                node.setValue(0);
                updateBadge(v.getId());

                break;
        }
        setResult(RESULT_OK, intent);
    }


    public void updateBadge(final int id){
        BadgeUtil.updateUI(this, id, treeNodes);
    }

    public void updateSettingBadgeView(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Set<Integer> set = treeNodes.keySet();
                for(Integer id : set){
                    TreeNode treeNode = treeNodes.get(id);
                    BadgeUtil.badgeSetForTextView(treeNode.getBadge(), treeNode.getValue());
                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            updateSettingBadgeView();
        }
    }
}
