package com.tim.test.dtos;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext arg1) throws IOException, JsonProcessingException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        String msDateString = node.textValue();

        if (msDateString == null || msDateString.length() == 0)
            return null;

        formatter.parse(msDateString).
//        String unicodeDateString = msDateString.substring(msDateString.indexOf("(")+1);
//        unicodeDateString = unicodeDateString.substring(0, unicodeDateString.indexOf(")"));
//        Date date = new Date(Long.valueOf(unicodeDateString) * 1000);
//        return date;
        return null;
    }
}
