package duehee.duehee_blog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.sun.source.tree.OpensTree;

import duehee.duehee_blog.domain.Article;

public interface ArticleRepository extends Repository<Article, Long> {
    Article save(Article article);

    Optional<Article> findById(Long id);

    List<Article> findAll();

    default Article getById(Long id) {
        return findById(id).orElseThrow(() -> new IllegalArgumentException("유저 id를 찾을 수 없습니다."));
    }

    Void deleteById(Long id);
}
