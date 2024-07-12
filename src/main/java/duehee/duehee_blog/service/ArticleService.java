package duehee.duehee_blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import duehee.duehee_blog.domain.Article;
import duehee.duehee_blog.dto.ArticleCreateRequest;
import duehee.duehee_blog.dto.ArticleResponse;
import duehee.duehee_blog.dto.ArticleUpdateRequest;
import duehee.duehee_blog.repository.ArticleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional
    public Article createArticle(ArticleCreateRequest request) {
        return articleRepository.save(request.toEntity());
    }

    public Article findArticleById(Long id) {
        return articleRepository.getById(id);
    }

    public List<ArticleResponse> findAllArticle() {
        return articleRepository.findAll().stream()
            .map(ArticleResponse::from)
            .toList();
    }

    @Transactional
    public Article updateArticle(Long id, ArticleUpdateRequest request) {
        Article article = articleRepository.getById(id);
        article.update(request.title(), request.content());
        return article;
    }

    @Transactional
    public void deleteById(Long id) {
        articleRepository.deleteById(id);
    }
}
