package net.chandol.study.oop.article.service;

import net.chandol.study.oop.article.dto.ArticleCreateRequest;
import net.chandol.study.oop.article.dto.ArticleModifyRequest;
import net.chandol.study.oop.article.model.Article;
import net.chandol.study.oop.article.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static net.chandol.study.oop.article.model.Tag.toTagList;
import static org.springframework.data.domain.Sort.Direction.DESC;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Transactional
    public Article createArticle(ArticleCreateRequest request){

        Article article = Article.builder()
                .withTitle(request.getTitle())
                .withAuthor(request.getAuthor())
                .withContents(request.getContents())
                .withPassword(request.getPassword())
                .withTags(toTagList(request.getTags()))
                .build();

        return articleRepository.save(article);
    }

    @Transactional
    public Article modifyArticle(Article article, ArticleModifyRequest request){

        article.modify(request.getTitle(),request.getAuthor(),
                request.getPassword(), request.getContents(),
                toTagList(request.getTags()));

        return articleRepository.save(article);
    }

    @Transactional
    public void deleteArticle(Article article){
        articleRepository.delete(article);
    }

    public Page<Article> getArticlePage(Integer page){
        PageRequest pageRequest = new PageRequest(page, 10, new Sort(DESC, "id"));
        return articleRepository.findAll(pageRequest);
    }
}
