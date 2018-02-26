package player.data.newsfeed.dao;

import org.apache.ibatis.annotations.Insert;
import player.data.newsfeed.model.TechMeituanArticle;


public interface NfLatestArticleDAO {

    @Insert("INSERT INTO nf_latest_article  " +
            "( article_id, article_title, article_url, article_summary, article_author, article_author_url, article_gmt_create, tag, source_name, article_comment_num, article_view_num, article_like_num, rating_score_cur, article_author_avatar_url, article_thumb_url, source_type, gmt_create, field_placeholder)  " +
            "VALUES( #{articleId}, #{articleTitle}, #{articleUrl}, #{articleSummary},#{articleAuthor} , #{articleAuthorUrl}, #{articleGmtCreate}, #{tag}, #{sourceName}, #{articleCommentNum}, #{articleViewNum}, #{articleLikeNum}, #{ratingScoreCur}, #{articleAuthorAvatarUrl}, #{articleThumbUrl}, #{sourceType}, #{gmtCreate}, #{fieldPlaceholder});")
    int add(TechMeituanArticle nfLatestArticle);
//    int add(NfLatestArticle nfLatestArticle);
}
