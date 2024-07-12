package duehee.duehee_blog.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import duehee.duehee_blog.domain.Article;
import duehee.duehee_blog.dto.ArticleCreateRequest;
import duehee.duehee_blog.dto.ArticleResponse;
import duehee.duehee_blog.dto.ArticleUpdateRequest;
import duehee.duehee_blog.service.ArticleService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/articles")
public class ArticleController implements ArticleApi {

    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<ArticleResponse> createArticle(@RequestBody ArticleCreateRequest request) {
        ArticleResponse saveArticle = ArticleResponse.from(articleService.createArticle(request));
        return ResponseEntity.ok(saveArticle);
    }

    @GetMapping
    public ResponseEntity<List<ArticleResponse>> findAllArticle() {
        List<ArticleResponse> articleResponses = articleService.findAllArticle();
        return ResponseEntity.ok(articleResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable Long id) {
        Article article = articleService.findArticleById(id);
        return ResponseEntity.ok(ArticleResponse.from(article));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticleById(@PathVariable Long id,
        @RequestBody ArticleUpdateRequest request) {
        Article article = articleService.updateArticle(id, request);
        return ResponseEntity.ok().body(article);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticleById(@PathVariable Long id) {
        articleService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
