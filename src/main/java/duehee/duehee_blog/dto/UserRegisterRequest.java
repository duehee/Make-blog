package duehee.duehee_blog.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;

public record UserRegisterRequest
    (
        @Schema(name = "이메일", example = "duehee@naver.com")
        String email,

        @Schema(name = "비밀번호", example = "1234")
        String password
    ) {
}
