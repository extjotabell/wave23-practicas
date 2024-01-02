package com.meli.socialmeli.utilities;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.meli.socialmeli.exceptions.custom.BadRequestException;
import org.springframework.http.converter.HttpMessageNotReadableException;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomLocalDateDeserializer extends StdDeserializer<LocalDate> {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public CustomLocalDateDeserializer(){
        this(null);
    }

    public CustomLocalDateDeserializer(Class<?> vc){
        super(vc);
    }

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JacksonException {
        try{
            String date = jsonParser.getValueAsString();
            return LocalDate.parse(date, formatter);
        }catch(Exception e){
            return LocalDate.MIN;
        }

    }

}
