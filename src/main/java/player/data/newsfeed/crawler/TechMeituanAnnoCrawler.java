package player.data.newsfeed.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import player.data.newsfeed.model.TechMeituanArticle;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;


@Component
public class TechMeituanAnnoCrawler {

    @Qualifier("NfLatestArticleDaoPipeline")
    @Autowired
    private PageModelPipeline pageModelPipeline;

    public void start() {
        OOSpider.create(
                Site.me().setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36"),
                pageModelPipeline,
                TechMeituanArticle.class)
                .addUrl("https://tech.meituan.com/?l=320")
                .thread(12)
                .run();
    }

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext*.xml");
        TechMeituanAnnoCrawler jobCrawler = applicationContext.getBean(TechMeituanAnnoCrawler.class);
        jobCrawler.start();
    }
}
