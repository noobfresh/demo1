package com.example.administrator.demo1.model.entity.json;

import java.util.List;

/**
 * Created by Administrator on 2017/12/25.
 */

public class HomeNewsBeanPage {

    private String allPages;
    private String currentPage;
    private String allNum;
    private String maxResult;
    private List<HomeNewsBeanContent> contentlist;

    public HomeNewsBeanPage(String allPages, String currentPage,
                            String allNum, String maxResult,
                            List<HomeNewsBeanContent> contentlist) {
        this.allPages = allPages;
        this.currentPage = currentPage;
        this.allNum = allNum;
        this.maxResult = maxResult;
        this.contentlist = contentlist;
    }

    public HomeNewsBeanPage() {
    }

    public String getAllPages() {
        return allPages;
    }

    public void setAllPages(String allPages) {
        this.allPages = allPages;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getAllNum() {
        return allNum;
    }

    public void setAllNum(String allNum) {
        this.allNum = allNum;
    }

    public String getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(String maxResult) {
        this.maxResult = maxResult;
    }

    public List<HomeNewsBeanContent> getContentlist() {
        return contentlist;
    }

    public void setContentlist(List<HomeNewsBeanContent> contentlist) {
        this.contentlist = contentlist;
    }
}
