package com.dimka.telegram.dto.mapper;

import com.dimka.telegram.dto.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.codec.StringDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;

@Slf4j
public class ResponseObjectMapper extends StringDecoder {



    @Override
    public Object decode(feign.Response response, Type type) throws IOException, DecodeException, FeignException {
        Object decode = super.decode(response, type);
        return decode;
    }
}
