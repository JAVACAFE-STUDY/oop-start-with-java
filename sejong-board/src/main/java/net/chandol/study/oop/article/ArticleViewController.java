package net.chandol.study.oop.article;


import net.chandol.study.oop.article.dto.ArticleCreateRequest;
import net.chandol.study.oop.article.model.Article;
import net.chandol.study.oop.article.service.ArticleService;
import net.chandol.study.oop.common.SimplePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.data.domain.Sort.Direction.DESC;


@Controller
public class ArticleViewController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/articles")
    public String getArticlePage(
            @RequestParam(defaultValue = "0") Integer page,
            Model model) {

        Pageable pageable = new PageRequest(page, 10, new Sort(DESC, "id"));
        SimplePage<Article> articlePage = SimplePage.create(articleService.getArticlePage(pageable));

        model.addAttribute("articlePage", articlePage);

        return "/article/articlePage";
    }

    @PostMapping("/articles")
    public String createArticlePage(ArticleCreateRequest createRequest) {
        articleService.createArticle(createRequest);
        return "redirect:/articles";
    }

    @GetMapping("/articles/write")
    public String articleWriteForm() {
        return "/article/articleWrite";
    }

    @GetMapping("/articles/{articleId}")
    public String getArticle(
            @PathVariable("articleId") Article article,
            Model model) {

        model.addAttribute("article", article);
        return "/article/article";
    }
}
