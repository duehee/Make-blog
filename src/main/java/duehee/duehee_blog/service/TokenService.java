package duehee.duehee_blog.service;

import java.time.Duration;

import org.springframework.stereotype.Service;

import duehee.duehee_blog.config.jwt.TokenProvider;
import duehee.duehee_blog.domain.User;
import duehee.duehee_blog.domain.jwt.RefreshToken;
import duehee.duehee_blog.repository.RefreshTokenRepository;
import duehee.duehee_blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;

    public String createNewAccessToken(String refreshToken){
        if(!tokenProvider.validToken(refreshToken))
            try {
                throw new IllegalAccessException("Token이 유효하지 않습니다.");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        Long userId = refreshTokenRepository.getByRefreshToken(refreshToken).getUserId();
        User user = userRepository.getById(userId);

        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }
}
