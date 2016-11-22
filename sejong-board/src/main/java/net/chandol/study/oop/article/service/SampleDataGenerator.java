package net.chandol.study.oop.article.service;

import net.chandol.study.oop.article.dto.ArticleCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class SampleDataGenerator {
    @Autowired
    ArticleService articleService;

    // 테스트 샘플 데이터 생성하기
    @PostConstruct
    public void generateSampleData() {
        List<String> tags = newArrayList("java", "spring", "jpa");
        for (int idx = 0; idx < 100; idx++) {
            articleService.createArticle(new ArticleCreateRequest("title" + idx, "body" + idx, "author" + idx, "pw" + idx, tags));
        }
    }
}
