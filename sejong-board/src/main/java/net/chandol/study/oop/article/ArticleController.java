package net.chandol.study.oop.article;

import net.chandol.study.oop.article.dto.ArticleCreateRequest;
import net.chandol.study.oop.article.dto.ArticlePageResponse;
import net.chandol.study.oop.article.dto.ArticleUpdateRequest;
import net.chandol.study.oop.article.model.Article;
import net.chandol.study.oop.article.service.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/articles")
    public ResponseEntity<Article> createArticle(
            @RequestBody ArticleCreateRequest request) {

        Article article = articleService.createArticle(request);
        return ResponseEntity.ok(article);
    }

    @GetMapping("/articles")
    public ResponseEntity<Page<ArticlePageResponse>> pageableArticle(
            @RequestParam(defaultValue = "0") int page) {

        Pageable pageable = new PageRequest(page, 10);
        Page<Article> articlePage = articleService.getArticlePage(pageable);
        Page<ArticlePageResponse> articlePageResponses
                = articlePage.map(article -> modelMapper.map(article, ArticlePageResponse.class));
        return ResponseEntity.ok(articlePageResponses);
    }

    @GetMapping("/articles/{articleId}")
    public ResponseEntity<Article> getArticle(
            @PathVariable("articleId") Article article) {

        return ResponseEntity.ok(article);
    }

    @PutMapping("/articles/{articleId}")
    public ResponseEntity<Article> modifyArticle(
            @PathVariable("articleId") Article article,
            ArticleUpdateRequest request) {

        Article modifiedArticle = articleService.modifyArticle(article, request);
        return ResponseEntity.ok(modifiedArticle);
    }

}
