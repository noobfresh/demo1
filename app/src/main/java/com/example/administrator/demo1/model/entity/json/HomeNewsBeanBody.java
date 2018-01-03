package com.example.administrator.demo1.model.entity.json;

/**
 * Created by Administrator on 2017/12/25.
 */

public class HomeNewsBeanBody {
    private String ret_code;
    private HomeNewsBeanPage pagebean;

    public HomeNewsBeanBody(String ret_code, HomeNewsBeanPage pagebean) {
        this.ret_code = ret_code;
        this.pagebean = pagebean;
    }

    public HomeNewsBeanBody() {
    }

    public String getRet_code() {
        return ret_code;
    }

    public void setRet_code(String ret_code) {
        this.ret_code = ret_code;
    }

    public HomeNewsBeanPage getPagebean() {
        return pagebean;
    }

    public void setPagebean(HomeNewsBeanPage pagebean) {
        this.pagebean = pagebean;
    }
}
