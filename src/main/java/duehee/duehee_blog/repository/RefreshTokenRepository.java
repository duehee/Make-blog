package duehee.duehee_blog.repository;

import java.util.Optional;

import org.springframework.data.repository.Repository;

import duehee.duehee_blog.domain.jwt.RefreshToken;

public interface RefreshTokenRepository extends Repository<RefreshToken, Long> {
    Optional<RefreshToken> findByUserId(Long id);
    Optional<RefreshToken> findByRefreshToken(String refreshToken);



    default RefreshToken getByRefreshToken(String refreshToken) {
        return findByRefreshToken(refreshToken).orElseThrow(() -> new IllegalArgumentException("리프레시 토큰을 찾을 수 없습니다!"));
    }
}
