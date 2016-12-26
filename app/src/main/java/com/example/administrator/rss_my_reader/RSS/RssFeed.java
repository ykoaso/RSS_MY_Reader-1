package com.example.administrator.rss_my_reader.RSS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Created by Administrator on 2016/12/26.
 */

public class RssFeed {
    private String title;       //标题
    private String pubdate;         //发布日期
    private int itemCount;              //列表的数量
    private List<RssItem> rssItems;         //用于描述列的Item

    public RssFeed(){
        rssItems = new ArrayList<RssItem>();
    }


    //完成RSSItem的条目添加，并返回列表的长度
    public int addItem(RssItem rssItem){
        rssItems.add(rssItem);
        itemCount++;
        return itemCount;
    }


    //根据下标获取
    public RssItem getItem(int position){
        return rssItems.get(position);
    }

    public List<HashMap<String,Objects>> getAllItems(){
        List<HashMap<String,Objects>> data = new ArrayList<HashMap<String,Objects>>();
        for (int i = 0;i<rssItems.size();i++){
            HashMap<String,Objects> item = new HashMap<String,Objects>();
            item.put(RssItem.TITLE,rssItems.get(i).getTitle());
            item.put(RssItem.PUBDATE,rssItems.get(i).getPubdate());
            data.add(item);
        }
        return data;
    }


    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getPubdate(){
        return pubdate;
    }

    public void setPubdate(String pubdate){
        this.pubdate = pubdate;
    }

    public int getItemCount(){
        return itemCount;
    }

    public void setItemCount(int itemCount){
        this.itemCount = itemCount;
    }
}
