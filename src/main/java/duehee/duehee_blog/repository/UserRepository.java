package duehee.duehee_blog.repository;

import java.util.Optional;

import org.springframework.data.repository.Repository;

import duehee.duehee_blog.domain.User;

public interface UserRepository extends Repository<User, Long> {
    Optional<User> findByEmail(String email);

    User save(User user);

    default User getByEmail(String email) {
        return findByEmail(email).orElseThrow(() -> new IllegalArgumentException("이메일이 없어요!"));
    }
}
