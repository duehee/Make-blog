package duehee.duehee_blog.config.jwt;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
@Configuration("jwt")
public class JwtProperties {
    private String issuer;
    private String secretKey;
}
