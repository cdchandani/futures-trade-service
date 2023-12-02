package com.chanchal.futurestradeservice.mappers;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IMapper<K> {
    K map(String message) throws JsonProcessingException;
}
