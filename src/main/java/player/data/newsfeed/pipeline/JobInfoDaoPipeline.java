package player.data.newsfeed.pipeline;

import org.springframework.stereotype.Component;
import player.data.newsfeed.dao.JobInfoDAO;
import player.data.newsfeed.model.LieTouJobInfo;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;

/**
 * @author code4crafer@gmail.com
 * Date: 13-6-23
 * Time: 下午8:56
 */
@Component("JobInfoDaoPipeline")
public class JobInfoDaoPipeline implements PageModelPipeline<LieTouJobInfo> {

    @Resource
    private JobInfoDAO jobInfoDAO;

    @Override
    public void process(LieTouJobInfo lieTouJobInfo, Task task) {
        jobInfoDAO.add(lieTouJobInfo);
    }
}
