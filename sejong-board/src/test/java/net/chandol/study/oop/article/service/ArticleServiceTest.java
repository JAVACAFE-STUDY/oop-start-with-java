package net.chandol.study.oop.article.service;

import net.chandol.study.oop.article.dto.ArticleCreateRequest;
import net.chandol.study.oop.article.dto.ArticleModifyRequest;
import net.chandol.study.oop.article.model.Article;
import net.chandol.study.oop.article.model.Tag;
import net.chandol.study.oop.article.repository.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("unit-test")
public class ArticleServiceTest {

    @Autowired
    ArticleService articleService;
    @Autowired
    ArticleRepository articleRepository;

    @Test
    public void 게시물_만들기() throws Exception {
        //given
        ArticleCreateRequest request1 = new ArticleCreateRequest("타이틀1", "본문1", "박세종", "pw1", newArrayList("aa", "bb"));
        ArticleCreateRequest request2 = new ArticleCreateRequest("타이틀2", "본문2", "박세종", "pw2", newArrayList("cc", "dd"));

        //when
        Article article1 = articleService.createArticle(request1);
        Article article2 = articleService.createArticle(request2);

        //then
        assertThat(article1.getTitle()).isEqualTo("타이틀1");
        assertThat(article1.getContents()).isEqualTo("본문1");
        assertThat(article1.getAuthor()).isEqualTo("박세종");
        assertThat(article1.getPassword()).isEqualTo("pw1");
        assertThat(article1.getTags()).contains(new Tag("aa"));

        assertThat(article2.getTitle()).isEqualTo("타이틀2");
        assertThat(article2.getContents()).isEqualTo("본문2");
        assertThat(article2.getAuthor()).isEqualTo("박세종");
        assertThat(article2.getPassword()).isEqualTo("pw2");
        assertThat(article2.getTags()).contains(new Tag("cc"));
    }

    @Test
    public void 게시물_수정하기() throws Exception {
        //given
        Article article = articleService.createArticle(new ArticleCreateRequest("타이틀1", "본문1", "박세종", "pw1", newArrayList("aa", "bb")));
        ArticleModifyRequest request = new ArticleModifyRequest("title1", "contents1", "Sejong Park", "pw1", newArrayList("cc", "dd"));

        //when
        Article modifiedArticle = articleService.modifyArticle(article, request);

        //then
        assertThat(modifiedArticle.getTitle()).isEqualTo("title1");
        assertThat(modifiedArticle.getContents()).isEqualTo("contents1");
        assertThat(modifiedArticle.getAuthor()).isEqualTo("Sejong Park");
    }

    @Test
    public void 게시물_삭제하기() throws Exception {
        //given
        Article article1 = articleService.createArticle(new ArticleCreateRequest("타이틀1", "본문1", "박세종", "pw1", newArrayList("aa", "bb")));
        Article article2 = articleService.createArticle(new ArticleCreateRequest("타이틀1", "본문1", "박세종", "pw1", newArrayList("aa", "bb")));

        //when
        articleService.deleteArticle(article1);

        //then
        articleRepository.findOne(article1.getId());
        articleRepository.findOne(article2.getId());
    }

}