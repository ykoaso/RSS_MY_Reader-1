package com.example.administrator.rss_my_reader.Tools;

import com.example.administrator.rss_my_reader.RSS.RssFeed;
import com.example.administrator.rss_my_reader.RSS.RssHandler;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Administrator on 2016/12/28.
 */

public class RSSFeed_SAXParser {

    public RssFeed getFeed(String urlStr)throws ParserConfigurationException,SAXException,IOException
    {
        URL url = new URL(urlStr);
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser =saxParserFactory.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        RssHandler rssHandler = new RssHandler();
        xmlReader.setContentHandler(rssHandler);
        InputSource inputSource = new InputSource(url.openStream());
        xmlReader.parse(inputSource);
        return rssHandler.getRssFeed();
    }
}
