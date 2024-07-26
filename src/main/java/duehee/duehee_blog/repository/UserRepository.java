package duehee.duehee_blog.repository;

import java.util.Optional;

import org.springframework.data.repository.Repository;

import duehee.duehee_blog.domain.User;

public interface UserRepository extends Repository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);

    User save(User user);

    default User getByEmail(String email) {
        return findByEmail(email).orElseThrow(() -> new IllegalArgumentException("이메일이 존재하지 않습니다."));
    }

    default User getById(Long id) {
        return findById(id).orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));
    }
}
