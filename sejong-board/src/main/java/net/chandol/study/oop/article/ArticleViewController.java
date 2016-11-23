package net.chandol.study.oop.article;


import net.chandol.study.oop.article.model.Article;
import net.chandol.study.oop.article.service.ArticleService;
import net.chandol.study.oop.common.SimplePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ArticleViewController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/articles")
    public String getArticlePage(
            @RequestParam(defaultValue = "0") Integer page, Model model) {

        Pageable pageable = new PageRequest(page, 10);
        Page<Article> articlePage = SimplePage.create(articleService.getArticlePage(pageable));

        model.addAttribute("articlePage", articlePage);

        return "/article/articlePage";
    }
}
