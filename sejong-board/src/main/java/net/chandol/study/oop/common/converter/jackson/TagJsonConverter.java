package net.chandol.study.oop.common.converter.jackson;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import net.chandol.study.oop.article.model.Tag;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

// Jackson을 활용, Money를 변환하여 저장한다.
@JsonComponent
public class TagJsonConverter {

    public static class Serializer extends JsonSerializer<Tag> {
        @Override
        public void serialize(Tag tag, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            String name = tag.getName();
            jsonGenerator.writeString(name);
        }
    }

    public static class Deserializer extends JsonDeserializer<Tag> {
        @Override
        public Tag deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            return new Tag(jsonParser.getValueAsString());
        }
    }

}
