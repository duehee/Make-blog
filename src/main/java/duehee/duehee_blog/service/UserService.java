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
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long register(UserRegisterRequest request) {
        return userRepository.save(User.builder()
            .email(request.email())
            .password(bCryptPasswordEncoder.encode(request.password()))
            .build()).getId();
    }
}
