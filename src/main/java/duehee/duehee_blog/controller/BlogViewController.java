package duehee.duehee_blog.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import duehee.duehee_blog.domain.Article;
import duehee.duehee_blog.dto.ArticleListViewResponse;
import duehee.duehee_blog.dto.ArticleViewResponse;
import duehee.duehee_blog.service.ArticleService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BlogViewController {
    private final ArticleService articleService;

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleListViewResponse> articles = articleService.findAllArticle().stream()
            .map(ArticleListViewResponse::new)
            .toList();
        model.addAttribute("articles", articles);

        return "articleList";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = articleService.findArticleById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }

    @GetMapping("/new-article")
    public String createNewArticle(@RequestParam(required = false) Long id, Model model) {
        if (id == null) {
            model.addAttribute("article", new ArticleViewResponse());
        } else {
            Article article = articleService.findArticleById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }
        return "newArticle";
    }
}
