package com.example.administrator.demo1.model.entity.tree;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

import com.example.administrator.demo1.util.BadgeUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import q.rorbin.badgeview.Badge;

/**
 * Created by Administrator on 2018/1/3.
 */

public class TreeNode implements Serializable{

    private static final long serialVersionUID = 1L;

    public static int count = 0;

    private int value;
    private TreeNode parent;
    private static TreeNode mRoot;
    private List<TreeNode> kids;
    private transient Badge badge;
    private int id;
    private transient View view;

    public TreeNode(TreeNode parent, View view, Badge badge, int id) {
        this.parent = parent;
        this.view = view;
        this.badge = badge;
        this.id = id;
        count++;
        if(parent != null){
            parent.addChild(parent, this);
        }
    }


    public void addChild(TreeNode parent, TreeNode kid){
        if(parent.kids == null){
            parent.kids = new ArrayList<>();
        }
        parent.kids.add(kid);
        parent.addUpdateParent(kid);
    }


    //新节点加入时，更新父母节点的值。
    public void addUpdateParent(TreeNode kid){
        this.value += kid.value;
    }

    //子节点值变化时，更新父母节点的值
    public void updateParent(int delta){
        this.value += delta;
        if(this.parent != null){
            this.parent.updateParent(delta);
        }
    }

    public void initData(){

    }

    public static void setmRoot(TreeNode node){
        mRoot = node;
    }

    public static TreeNode getmRoot(){
        return mRoot;
    }


    public int getValue() {
        return value;
    }

        public void setValue(int value) {
        int delta = value - this.value;
        if(this.parent != null){
            this.parent.updateParent(delta);
        }
        this.value = value;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public List<TreeNode> getKids() {
        return kids;
    }

    public void setKids(List<TreeNode> kids) {
        this.kids = kids;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //遍历获得
    public static TreeNode getSpecificTreeNode(int id){
        List<TreeNode> nodes = levelTrav();
        for(TreeNode node : nodes){
            if(node.getId() == id){
                return node;
            }
        }
        return null;
    }


    public static List<TreeNode> levelTrav(){
        TreeNode root = mRoot;
        if(root == null){
            return null;
        }
        TreeNode temp;
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> ans = new ArrayList<>();
        queue.add(root);
        while (queue.size() != 0){
            temp = queue.poll();
            if(temp.kids != null){
                queue.addAll(temp.kids);
            }
            ans.add(temp);
        }
        return ans;
    }


    //过滤非子节点
    public static List<TreeNode> filter(List<TreeNode> treeNodes){
        List<TreeNode> list = new ArrayList<>();
        for(TreeNode node : treeNodes){
            if(node.kids == null){
                list.add(node);
            }
        }
        return list;
    }

}
