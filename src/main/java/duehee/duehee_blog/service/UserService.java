package duehee.duehee_blog.service;

import org.aspectj.weaver.bcel.BcelAnnotation;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import duehee.duehee_blog.domain.User;
import duehee.duehee_blog.dto.UserRegisterRequest;
import duehee.duehee_blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Long register(UserRegisterRequest request) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return userRepository.save(User.builder()
            .email(request.email())
            .password(encoder.encode(request.password()))
            .build()).getId();
    }
}
