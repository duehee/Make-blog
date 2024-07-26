package duehee.duehee_blog.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record CreateAccessTokenResponse
    (
        @Schema(description = "Access Token")
        String accessToken
    ){
}
