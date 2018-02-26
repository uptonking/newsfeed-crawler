package player.data.newsfeed.model;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import java.util.Date;

/**
 * 美团点评博客的技术文章page model
 * <p>
 * TargetUrl要多次尝试，改用*时就用，避免漏匹配
 */
//@TargetUrl("https://tech.meituan.com/(\\w+)(-*)(\\w*).html")
@TargetUrl("https://tech.meituan.com/*.html")
public class TechMeituanArticle {

    private String articleId;

    @ExtractBy("//header/h1/text()")
    private String articleTitle;

    private String articleUrl;

    private String articleSummary;

    @ExtractBy("//span[@class='nick']/text()")
    private String articleAuthor;

    private String articleAuthorUrl;

    private Date articleGmtCreate;

    @ExtractBy("//div[@class='article__meta']/allText()")
    private String tag;

    private String sourceName;

    private Integer articleCommentNum;

    private Integer articleViewNum;

    private Integer articleLikeNum;

    private String ratingScoreCur;

    private String articleAuthorAvatarUrl;

    private String articleThumbUrl;

    private String sourceType;

    private Date gmtCreate;

    @ExtractBy("//span[@class='date']/text()")
    private String fieldPlaceholder;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl == null ? null : articleUrl.trim();
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary == null ? null : articleSummary.trim();
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor == null ? null : articleAuthor.trim();
    }

    public String getArticleAuthorUrl() {
        return articleAuthorUrl;
    }

    public void setArticleAuthorUrl(String articleAuthorUrl) {
        this.articleAuthorUrl = articleAuthorUrl == null ? null : articleAuthorUrl.trim();
    }

    public Date getArticleGmtCreate() {
        return articleGmtCreate;
    }

    public void setArticleGmtCreate(Date articleGmtCreate) {
        this.articleGmtCreate = articleGmtCreate;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName == null ? null : sourceName.trim();
    }

    public Integer getArticleCommentNum() {
        return articleCommentNum;
    }

    public void setArticleCommentNum(Integer articleCommentNum) {
        this.articleCommentNum = articleCommentNum;
    }

    public Integer getArticleViewNum() {
        return articleViewNum;
    }

    public void setArticleViewNum(Integer articleViewNum) {
        this.articleViewNum = articleViewNum;
    }

    public Integer getArticleLikeNum() {
        return articleLikeNum;
    }

    public void setArticleLikeNum(Integer articleLikeNum) {
        this.articleLikeNum = articleLikeNum;
    }

    public String getRatingScoreCur() {
        return ratingScoreCur;
    }

    public void setRatingScoreCur(String ratingScoreCur) {
        this.ratingScoreCur = ratingScoreCur == null ? null : ratingScoreCur.trim();
    }

    public String getArticleAuthorAvatarUrl() {
        return articleAuthorAvatarUrl;
    }

    public void setArticleAuthorAvatarUrl(String articleAuthorAvatarUrl) {
        this.articleAuthorAvatarUrl = articleAuthorAvatarUrl == null ? null : articleAuthorAvatarUrl.trim();
    }

    public String getArticleThumbUrl() {
        return articleThumbUrl;
    }

    public void setArticleThumbUrl(String articleThumbUrl) {
        this.articleThumbUrl = articleThumbUrl == null ? null : articleThumbUrl.trim();
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getFieldPlaceholder() {
        return fieldPlaceholder;
    }

    public void setFieldPlaceholder(String fieldPlaceholder) {
        this.fieldPlaceholder = fieldPlaceholder == null ? null : fieldPlaceholder.trim();
    }

    @Override
    public String toString() {
        return "NfLatestArticleModel{" +
                " articleId='" + articleId + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleUrl='" + articleUrl + '\'' +
                ", articleSummary='" + articleSummary + '\'' +
                ", articleAuthor='" + articleAuthor + '\'' +
                ", articleAuthorUrl='" + articleAuthorUrl + '\'' +
                ", articleGmtCreate=" + articleGmtCreate +
                ", tag='" + tag + '\'' +
                ", sourceName='" + sourceName + '\'' +
                ", articleCommentNum=" + articleCommentNum +
                ", articleViewNum=" + articleViewNum +
                ", articleLikeNum=" + articleLikeNum +
                ", ratingScoreCur='" + ratingScoreCur + '\'' +
                ", articleAuthorAvatarUrl='" + articleAuthorAvatarUrl + '\'' +
                ", articleThumbUrl='" + articleThumbUrl + '\'' +
                ", sourceType='" + sourceType + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", fieldPlaceholder='" + fieldPlaceholder + '\'' +
                '}';
    }
}
