package duehee.duehee_blog.service;

import org.springframework.stereotype.Service;

import duehee.duehee_blog.domain.jwt.RefreshToken;
import duehee.duehee_blog.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
}
