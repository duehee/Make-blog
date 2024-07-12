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

import duehee.duehee_blog.domain.Article;
import duehee.duehee_blog.dto.ArticleCreateRequest;
import duehee.duehee_blog.dto.ArticleResponse;
import duehee.duehee_blog.dto.ArticleUpdateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "게시물 CRUD", description = "블로그 게시물 CRUD")
public interface ArticleApi {

    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "401", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(hidden = true)))
        }
    )
    @Operation(summary = "게시물 생성하기")
    @PostMapping("/article")
    ResponseEntity<ArticleResponse> createArticle
        (
            @RequestBody ArticleCreateRequest request
        );

    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(hidden = true)))
        }
    )
    @Operation(summary = "모든 게시물 조회하기")
    @GetMapping("/article")
    ResponseEntity<List<ArticleResponse>> findAllArticle();

    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(hidden = true)))
        }
    )
    @Operation(summary = "id로 게시물 조회하기")
    @GetMapping("/article/{id}")
    ResponseEntity<ArticleResponse> findArticle
        (
            @PathVariable Long id
        );

    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(hidden = true)))
        }
    )
    @Operation(summary = "id로 게시물 수정하기")
    @PutMapping("/article/{id}")
    ResponseEntity<Article> updateArticleById
        (
            @PathVariable Long id, @RequestBody ArticleUpdateRequest request
        );


    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "204"),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(hidden = true)))
        }
    )
    @Operation(summary = "id로 게시물 삭제하기")
    @DeleteMapping("/article/{id}")
    ResponseEntity<Void> deleteArticleById
        (
            @PathVariable Long id
        );
}
