package duehee.duehee_blog.dto;

import java.time.LocalDateTime;

import duehee.duehee_blog.domain.Article;

public record ArticleViewResponse(
    Long id,
    String title,
    String content,
    LocalDateTime createdAt) {

    public ArticleViewResponse() {
        this(null, null, null, null); // 필드들을 기본값으로 초기화
    }

    public ArticleViewResponse(Article article) {
        this(article.getId(), article.getTitle(), article.getContent(), article.getCreatedAt());
    }
}

