package net.chandol.study.oop.article.model;

import lombok.Getter;

import javax.persistence.Embeddable;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
@Embeddable
public class Tag {
    String name;

    protected Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return name != null ? name.equals(tag.name) : tag.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public static List<Tag> toTagList(List<String> tags) {
        return tags.stream()
                .map(Tag::new)
                .collect(toList());
    }

    public static List<Tag> convert(String... elements) {
        return Arrays.stream(elements)
                .map(Tag::new)
                .collect(toList());
    }

    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                '}';
    }
}
