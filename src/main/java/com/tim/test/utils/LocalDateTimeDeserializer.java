package com.tim.test.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDate> {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[yyyy-MM-dd][yyyy-MM-dd HH:mm:ss]");

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext arg1) throws IOException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        String msDateString = node.textValue();

        if (msDateString == null || msDateString.length() == 0)
            return null;
//        return LocalDateTime.parse(msDateString, formatter);
        return LocalDate.parse(msDateString, formatter);
    }
}
