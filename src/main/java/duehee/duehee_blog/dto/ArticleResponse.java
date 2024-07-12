package duehee.duehee_blog.dto;

import duehee.duehee_blog.domain.Article;
import io.swagger.v3.oas.annotations.media.Schema;

public record ArticleResponse(
    @Schema(description = "게시물 id")
    Long id,

    @Schema(description = "게시물 제목", example = "게시물 제목 1")
    String title,

    @Schema(description = "게시물 내용", example = "게시물 내용 1")
    String content
) {
    public static ArticleResponse from(Article article) {
        return new ArticleResponse(
            article.getId(),
            article.getTitle(),
            article.getContent()
        );
    }
}
