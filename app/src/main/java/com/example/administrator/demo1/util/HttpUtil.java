package com.example.administrator.demo1.util;

import com.example.administrator.demo1.model.entity.News;
import com.example.administrator.demo1.model.entity.json.HomeNewsBean;
import com.example.administrator.demo1.model.entity.json.HomeNewsBeanContent;
import com.example.administrator.demo1.view.Activity.NewsActivity;
import com.example.administrator.demo1.view.Fragment.NewsFragment;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/12/25.
 */

public class HttpUtil {

    private static final String APPID = "52832";
    private static final String SIGN = "a9fea22a88bb4eada6d17fd7b904b3a5";
    private static final String NEWS_URL = "http://route.showapi.com/109-35";
    public static final String TAG = "HttpUtil";


    /**
     * 请求新闻目录
     * @param newsList
     * @param fragment
     */
    public static void requestForNews(final List<News> newsList,final NewsFragment fragment){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client = new OkHttpClient();
                    FormBody.Builder builder = new FormBody.Builder()
                            .add("showapi_appid", APPID)
                            .add("showapi_sign", SIGN)
                            .add("maxResult", "20");
                    RequestBody requestBody = builder.build();
                    Request request = new Request.Builder()
                            .url(NEWS_URL)
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    Gson gson = new Gson();
                    HomeNewsBean homeNewsBean = gson.fromJson(responseData, HomeNewsBean.class);
                    for(int i = 0;
                        i <homeNewsBean.getShowapi_res_body().getPagebean().getContentlist().size();
                        i++){
                        HomeNewsBeanContent content = homeNewsBean.getShowapi_res_body().getPagebean().getContentlist().get(i);
                        News news = new News(content.getId(), content.getTitle(), content.getDesc(), "AAAA", DateFormatUtil.transFormat(content.getPubDate()),
                                0, 0);
                        newsList.add(news);
                    }
                    fragment.showResponse();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public static void requestForSpecificNews(final String id, final NewsActivity activity){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client = new OkHttpClient();
                    FormBody.Builder builder = new FormBody.Builder()
                            .add("showapi_appid", APPID)
                            .add("showapi_sign", SIGN)
                            .add("id", id)
                            .add("needContent", "1");
                    RequestBody requestBody = builder.build();
                    Request request = new Request.Builder()
                            .url(NEWS_URL)
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    Gson gson = new Gson();
                    HomeNewsBean homeNewsBean = gson.fromJson(responseData, HomeNewsBean.class);
                    HomeNewsBeanContent content = homeNewsBean.getShowapi_res_body().getPagebean().getContentlist().get(0);
                    News news = new News(content.getId(), content.getTitle(), content.getDesc(), "AAAA", DateFormatUtil.transFormat(content.getPubDate()),
                            0, 0);
                    activity.updateContent(news);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }).start();

    }


}
