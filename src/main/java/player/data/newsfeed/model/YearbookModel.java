package player.data.newsfeed.model;

import us.codecraft.webmagic.model.annotation.ExtractBy;

/**
 * 统计年鉴bean
 * Created by yaoo on 2/26/18
 */
@ExtractBy(value = "//ul", multi = true)
public class YearbookModel {

    /**
     * 一级标题名
     */
    @ExtractBy("//li[@id='foldheader']/text()")
    private String header1;

    /**
     * 二级标题名
     */
    @ExtractBy("//li/a/text(1)")
    private String header2;

    /**
     * 一级标题所对应的ulr地址
     */
    @ExtractBy("//ul/a/@href")
    private String header1Url;

    /**
     * 二级标题所对应的ulr地址
     */
    @ExtractBy("//li/a/@href")
    private String header2Url;

    public String getHeader1() {
        return header1;
    }

    public void setHeader1(String header1) {
        this.header1 = header1;
    }

    public String getHeader2() {
        return header2;
    }

    public void setHeader2(String header2) {
        this.header2 = header2;
    }

    public String getHeader1Url() {
        return header1Url;
    }

    public void setHeader1Url(String header1Url) {
        this.header1Url = header1Url;
    }

    public String getHeader2Url() {
        return header2Url;
    }

    public void setHeader2Url(String header2Url) {
        this.header2Url = header2Url;
    }

    @Override
    public String toString() {
        return "YearbookModel{" +
                "header1='" + header1 + '\'' +
                ", header2='" + header2 + '\'' +
                ", header1Url='" + header1Url + '\'' +
                ", header2Url='" + header2Url + '\'' +
                '}';
    }
}
