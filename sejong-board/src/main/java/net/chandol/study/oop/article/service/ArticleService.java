package net.chandol.study.oop.article.service;

import net.chandol.study.oop.article.dto.ArticleCreateRequest;
import net.chandol.study.oop.article.dto.ArticleModifyRequest;
import net.chandol.study.oop.article.model.Article;
import net.chandol.study.oop.article.model.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static net.chandol.study.oop.article.model.Tag.create;
import static org.springframework.data.domain.Sort.Direction.DESC;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Transactional
    public Article createArticle(ArticleCreateRequest request){
        Article article = new Article(request.getTitle(), request.getAuthor(), request.getPassword(), request.getContents(), create(request.getTags()));
        return articleRepository.save(article);
    }

    @Transactional
    public Article modifyArticle(Article article, ArticleModifyRequest request){
        article.modify(request.getTitle(), request.getAuthor(), request.getPassword(), request.getContents(), create(request.getTags()));
        return articleRepository.save(article);
    }

    public Page<Article> getArticlePage(Integer page){
        Pageable pageable = new PageRequest(page, 10, new Sort(DESC, "id"));
        return articleRepository.findAll(pageable);
    }
}
