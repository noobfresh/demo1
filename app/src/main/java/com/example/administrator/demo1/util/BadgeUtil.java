package com.example.administrator.demo1.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.util.ArrayMap;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.demo1.R;
import com.example.administrator.demo1.model.entity.badge.AccpetVoiceVideoBadge;
import com.example.administrator.demo1.model.entity.badge.CardBadge;
import com.example.administrator.demo1.model.entity.badge.FirstLevelBadge;
import com.example.administrator.demo1.model.entity.badge.SettingBadge;
import com.example.administrator.demo1.model.entity.tree.TreeNode;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

/**
 * Created by Administrator on 2017/12/28.
 */

public class BadgeUtil {

    public static final String TAG = "BadgeUtil";

    public static void badgeSetForTextView(Badge badge, int num){
        badge.setBadgeNumber(num)
                .setExactMode(true)
                .setBadgeGravity(Gravity.CENTER| Gravity.END)
                .setShowShadow(true);
    }


    public static void randomBadge(){
        List<TreeNode> nodes = TreeNode.filter(TreeNode.levelTrav());
        int randomSize = nodes.size();
        Random random = new Random();
        int index = random.nextInt(randomSize);
        TreeNode node = nodes.get(index);
        node.setValue(node.getValue()+1);
    }

    public static void updateUI(Activity activity, final int id,final Map<Integer, TreeNode> map){
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TreeNode treeNode = map.get(id);
                BadgeUtil.badgeSetForTextView(treeNode.getBadge(), treeNode.getValue());
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static Map<Integer, TreeNode> initTreeNodeMap(int startId, int endId,
                                                  Activity activity, TreeNode root,
                                                  View.OnClickListener listener,
                                                         View view){
        Map<Integer, TreeNode> map = new ArrayMap<>();
        boolean flag = isInited(root);
        for (int i = startId; i < endId + 1; i++) {
            ViewGroup viewGroup = view.findViewById(i);
            Badge badge = null;
            for (int j = 0; j < viewGroup.getChildCount(); j++) {
                View text = viewGroup.getChildAt(j);
                if (text instanceof TextView) {
                    badge = new QBadgeView(activity).bindTarget(text);
                }
            }
            viewGroup.setOnClickListener(listener);
            TreeNode node;
            if(flag){
                node = new TreeNode(root, viewGroup, badge, TreeNode.count);
            }else {
                node = root.getKids().get(i - startId);
                node.setBadge(badge);
                node.setView(viewGroup);
            }
            map.put(viewGroup.getId(), node);
            updateUI(activity, i, map);
        }
        return map;
    }

    public static boolean isInited(TreeNode root){
        return root.getKids() == null || root.getKids().size() == 0;
    }
}
