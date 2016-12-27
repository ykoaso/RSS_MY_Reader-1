package com.example.administrator.rss_my_reader.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.TextViewCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.rss_my_reader.R;

/**
 * Created by Administrator on 2016/12/28.
 */

public class RSS_DESCIPTION extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_description);
        String content = null;
        Intent intent = getIntent();
        if (intent != null){
            Bundle bundle = intent.getBundleExtra("pagename.rssitem");
            if(bundle == null){
                content = "error!";
            }else{

                content = bundle.getString("title")+"nn"+
                        bundle.getString("pubdate")+"nn"+
                        bundle.getString("description").replace('n',' ')+
                        "nn详细信息请访问：n"+bundle.getString("link");

            }

        }else{
            content = "ERROR!";
        }

        TextView tv = (TextView)findViewById(R.id.content);
        tv.setText(content);
        Button bt = (Button)findViewById(R.id.description_back);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
