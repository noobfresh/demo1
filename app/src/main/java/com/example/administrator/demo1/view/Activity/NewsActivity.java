package com.example.administrator.demo1.view.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.demo1.R;
import com.example.administrator.demo1.model.entity.News;
import com.example.administrator.demo1.util.DateFormatUtil;
import com.example.administrator.demo1.util.HttpUtil;

public class NewsActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    private TextView contentTitle;

    private TextView contentAuthor;

    private TextView content;

    private TextView publishDate;

    private TextView contentAgree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
//        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
        progressBar = findViewById(R.id.progressBar2);
        progressBar.setVisibility(View.VISIBLE);
        HttpUtil.requestForSpecificNews(id, this);
        contentAgree = findViewById(R.id.content_agree);
        contentAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView view = (TextView)v;
                String text = String.valueOf(view.getText());
                //未设置点击限制，和将数据存入数据库，不对额- =数据本来就是从网络中取的23333
                int like = Integer.valueOf(text.split("赞同 ")[1]) + 1;
                contentAgree.setText("赞同 "+ like);
            }
        });
    }


    public void updateContent(final News news){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                content = findViewById(R.id.content);
                contentAgree = findViewById(R.id.content_agree);
                contentTitle = findViewById(R.id.content_title);
                contentAuthor = findViewById(R.id.content_author);
                publishDate = findViewById(R.id.publish_date);
                content.setText(news.getContent());
                contentAuthor.setText(news.getAuthor());
                contentTitle.setText(news.getTitle());
                String like = "赞同 " + news.getLike().toString();
                contentAgree.setText(like);
                publishDate.setText(DateFormatUtil.displayDateFormat(news.getDate()));
                progressBar.setVisibility(View.GONE);
            }
        });
    }

}
