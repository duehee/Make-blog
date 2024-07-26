package duehee.duehee_blog.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record CreateAccessTokenRequest
    (
        @Schema(description = "Refresh Token")
        String refreshToken
    ){
}
