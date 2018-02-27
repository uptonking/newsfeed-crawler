package player.data.singlepage;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import player.data.httpclient.HttpClientUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 人口普查数据
 * 页面解析
 * <p>
 * Created by yaoo on 2/27/18
 */
public class Census {


    public static void main(String[] args) {

        //k是标题id，v是一级标题
        Map<String, String> header1 = new HashMap<>();
        //k是标题id，v是二级标题
        Map<String, String> header2 = new HashMap<>();
        //k是url，v是三级标题，只有三级标题爬取url
        //使用url需要手动添加baseurl: http://www.stats.gov.cn/tjsj/pcsj/rkpc/6rp/excel/A0101b.xls
        Map<String, String> header3 = new HashMap<>();

        Document doc = null;
        try {
            doc = Jsoup.connect("http://www.stats.gov.cn/tjsj/pcsj/rkpc/6rp/lefte.htm").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //String title = doc.title();

        //========获取一级标题
        Elements h1List = doc.select("th > ul > li ");

        for (int i = 0, h1size = h1List.size(); i < h1size; i++) {
            header1.put("h1-" + i, h1List.get(i).text());
        }

        //========获取二级标题
        Elements h2List = doc.select("ul > li[id=foldheader]");

        ///二级标题内容修改
        for (int i = 0, h2size = h2List.size(); i < h2size; i++) {
            Element e2 = h2List.get(i);
            ///去除一级标题
            for (Element e1 : h1List) {
                if (e2.text().equals(e1.text())) {
                    h2List.remove(e2);
                    h2size--;
                    break;
                }
            }
        }
        Elements h2ListRemained = doc.select("ul>li > a[href^=html/fu] ");

        h2List.addAll(h2ListRemained);

        for (int j = 0, h2size = h2List.size(); j < h2size; j++) {
            header2.put("h2-" + j, h2List.get(j).text());
        }

        //========获取三级标题
        Elements h3List = doc.select("ul>li > a[href^=excel]");

        for (int k = 0, h3size = h3List.size(); k < h3size; k++) {
            Element e = h3List.get(k);
            String url = e.attr("href");
            String h3 = e.text();
            header3.put(url, h3);
        }


        System.out.println(h3List.size());
//        for (Map.Entry<String, String> e : header3.entrySet()) {
//            System.out.println(e.getKey() + ",    " + e.getValue());
//        }
        HttpClientUtil httpUtil = HttpClientUtil.getInstance();

        ///下载文件
        for (Map.Entry<String, String> e : header3.entrySet()) {
            String fileUrl = "http://www.stats.gov.cn/tjsj/pcsj/rkpc/6rp/" + e.getKey();
            httpUtil.download(fileUrl, "/root/Downloads/census2010/" + e.getKey());
//            System.out.println(e.getKey() + ",    " + e.getValue());
        }

//        for (Element e : h3List) {
//            System.out.println(e);
//        }

    }


}
