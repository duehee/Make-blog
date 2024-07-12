package duehee.duehee_blog.dto;

public record ArticleListViewResponse(
    Long id,
    String title,
    String content) {
    public ArticleListViewResponse(ArticleResponse articleResponse) {
        this(articleResponse.id(), articleResponse.title(), articleResponse.content());
    }
}
