package com.example.administrator.rss_my_reader.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.administrator.rss_my_reader.R;
import com.example.administrator.rss_my_reader.RSS.RssFeed;
import com.example.administrator.rss_my_reader.RSS.RssItem;
import com.example.administrator.rss_my_reader.Tools.RSSFeed_SAXParser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by Administrator on 2016/12/28.
 */

public class RSS_Main extends Activity implements AdapterView.OnItemClickListener{
    public final String RSS_URL = "http://news.qq.com/newsgn/rss_newsgn.xml";
    public final String tag = "RSS_READER";
    private RssFeed feed = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_show);

        try{
            feed = new RSSFeed_SAXParser().getFeed(RSS_URL);
            System.out.print(feed.getAllItems()+feed.getTitle());
        }
        catch (ParserConfigurationException e){
            e.printStackTrace();;
        }catch (SAXException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        showList();

    }

    private void showList(){
        ListView lv = (ListView)findViewById(R.id.lv_main);
        if(feed == null){
            setTitle("访问的RSS失效!-_-");
            return;
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,feed.getAllItems(),
                android.R.layout.simple_list_item_2,
                new  String[]{RssItem.TITLE,RssItem.PUBDATE},
                new int[]{android.R.id.text1,android.R.id.text2});
        lv.setAdapter(simpleAdapter);
        lv.setOnItemClickListener(this);
        lv.setSelection(0);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this,RSS_DESCIPTION.class);

        Bundle bundle = new Bundle();
        bundle.putString("title",feed.getItem(position).getTitle());
        bundle.putString("desciption",feed.getItem(position).getDescription());
        bundle.putString("link",feed.getItem(position).getLink());
        bundle.putString("pubdate",feed.getItem(position).getPubdate());
        intent.putExtra("pagename.rssitem",bundle);
        startActivityForResult(intent,0);

    }
}
