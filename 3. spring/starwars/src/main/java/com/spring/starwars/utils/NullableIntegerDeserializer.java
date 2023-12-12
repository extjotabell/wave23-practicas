package com.spring.starwars.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class NullableIntegerDeserializer extends StdDeserializer<Integer> {

    public NullableIntegerDeserializer() {
        this(null);
    }

    public NullableIntegerDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);
        if (node.isNull() || node.asText().equalsIgnoreCase("NA")) {
            return null;
        }
        return node.asInt();
    }
}