package net.chandol.study.oop.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import net.chandol.logjdbc.LogJdbcDataSource;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.sql.DataSource;

import static com.google.common.base.Predicates.not;
import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

@Configuration
public class SimpleConfiguration {

    @Bean
    public DataSource loggableDataSource(ResourceLoader resourceLoader) {
        EmbeddedDatabase database = new EmbeddedDatabaseBuilder(resourceLoader)
                .setType(H2)
                .build();

        return new LogJdbcDataSource(database);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


    @Bean
    public ObjectMapper objectMapper() {
        return Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(new JavaTimeModule())
                .build();
    }


    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                //Error controller 제거
                .paths(not(PathSelectors.regex("/error")))
                .build();
    }

}
