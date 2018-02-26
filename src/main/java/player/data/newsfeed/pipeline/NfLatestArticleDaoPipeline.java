package player.data.newsfeed.pipeline;

import org.springframework.stereotype.Component;
import player.data.newsfeed.dao.NfLatestArticleDAO;
import player.data.newsfeed.model.TechMeituanArticle;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;

/**
 * @author code4crafer@gmail.com
 * Date: 13-6-23
 * Time: 下午8:56
 */
@Component("NfLatestArticleDaoPipeline")
public class NfLatestArticleDaoPipeline implements PageModelPipeline<TechMeituanArticle> {

    @Resource
    private NfLatestArticleDAO nfLatestArticleDAO;

    @Override
    public void process(TechMeituanArticle nfLatestArticle, Task task) {
        nfLatestArticleDAO.add(nfLatestArticle);
    }
}
