package net.chandol.study.oop.article;


import net.chandol.study.oop.article.dto.ArticleCreateRequest;
import net.chandol.study.oop.article.dto.ArticleModifyRequest;
import net.chandol.study.oop.article.model.Article;
import net.chandol.study.oop.article.service.ArticleService;
import net.chandol.study.oop.common.SimplePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static java.lang.String.format;

@Controller
public class ArticleViewController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/articles")
    public String viewArticlePage(
            @RequestParam(defaultValue = "0") Integer page,
            Model model) {

        SimplePage<Article> articlePage
                = SimplePage.convert(articleService.getArticlePage(page));
        model.addAttribute("articlePage", articlePage);

        return "/article/articlePage";
    }

    @GetMapping("/articles/{articleId}")
    public String viewOneArticle(
            @PathVariable("articleId") Article article,
            Model model) {

        model.addAttribute("article", article);

        return "/article/article";
    }

    @GetMapping("/articles/write")
    public String viewArticleWriteForm() {
        return "/article/articleWrite";
    }

    @PostMapping("/articles")
    public String createArticle(
            ArticleCreateRequest createRequest) {

        Article article = articleService.createArticle(createRequest);
        return format("redirect:/articles/%d", article.getId());
    }

    @GetMapping("/articles/{articleId}/modify")
    public String viewArticleModify(
            @PathVariable("articleId") Article article,
            Model model) {

        model.addAttribute("article", article);
        return "/article/articleModify";
    }

    @PutMapping("/articles/{articleId}")
    public String modifyArticle(
            @PathVariable("articleId") Article article,
            ArticleModifyRequest modifyRequest) {

        articleService.modifyArticle(article, modifyRequest);
        return format("redirect:/articles/%d", article.getId());
    }
}
