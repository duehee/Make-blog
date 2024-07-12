package duehee.duehee_blog.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record ArticleUpdateRequest
    (
        @Schema(description = "게시물 제목", example = "게시물 제목 1")
        String title,

        @Schema(description = "게시물 내용", example = "게시물 내용 1")
        String content
    ){
}
