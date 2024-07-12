package duehee.duehee_blog.dto;

import java.time.LocalDateTime;

import duehee.duehee_blog.domain.Article;
import io.swagger.v3.oas.annotations.media.Schema;

public record ArticleResponse(
    @Schema(description = "게시물 id")
    Long id,

    @Schema(description = "게시물 제목", example = "게시물 제목 1")
    String title,

    @Schema(description = "게시물 내용", example = "게시물 내용 1")
    String content,

    @Schema(description = "게시물 작성 시간", example = "2024-07-12T19:32:03.647597")
    LocalDateTime createAt,

    @Schema(description = "게시물 수정 시간", example = "2024-07-12T19:32:03.647597")
    LocalDateTime updateAt
) {
    public static ArticleResponse from(Article article) {
        return new ArticleResponse(
            article.getId(),
            article.getTitle(),
            article.getContent(),
            article.getCreatedAt(),
            article.getUpdateAt()
        );
    }
}
