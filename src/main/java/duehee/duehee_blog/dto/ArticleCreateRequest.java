package duehee.duehee_blog.dto;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.*;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import duehee.duehee_blog.domain.Article;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@JsonNaming(value = SnakeCaseStrategy.class)
public record ArticleCreateRequest(
    @Schema(description = "게시물 이름", example = "게시물 1", requiredMode = REQUIRED)
    @NotNull(message = "게시물 이름은 비울 수 없어요.")
    String title,

    @Schema(description = "게시물 내용", example = "게시물 내용 1", requiredMode = REQUIRED)
    @NotNull(message = "게시물 내용은 비울 수 없어요.")
    String content
) {
    public Article toEntity() {
        return Article.builder()
            .title(title)
            .content(content)
            .build();
    }
}
