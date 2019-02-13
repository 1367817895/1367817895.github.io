package com.example.x.bean;

/**
 * @Auther: 刘青松
 * @Date: 2019/1/21 08:51:51
 * @Description:
 */
public class JavaBean {
    private String  news_id;

    private String news_summary;
    private String  news_title;
    private String  pic_url;

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

    public String getNews_summary() {
        return news_summary;
    }

    public void setNews_summary(String news_summary) {
        this.news_summary = news_summary;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public JavaBean(String news_id, String news_summary, String news_title, String pic_url) {
        this.news_id = news_id;
        this.news_summary = news_summary;
        this.news_title = news_title;
        this.pic_url = pic_url;
    }
//      "news_id": "13787",
//              "news_summary": "据广州市政府获悉，经中国花卉协会和广州市政府批准，第二届中国盆栽花卉交易会将于本月28日至31日在广州花卉博览园举行。届",
//              "news_title": "第二届中国盆栽花卉交易会​ 本月28日开幕",
//              "pic_url": "http://f.expoon.com/sub/news/2016/01/18/687647_230x162_0.jpg"


}
