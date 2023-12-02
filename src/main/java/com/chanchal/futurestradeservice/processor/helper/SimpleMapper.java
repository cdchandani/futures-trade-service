package com.chanchal.futurestradeservice.processor.helper;

import com.chanchal.futurestradeservice.bo.FuturesTradesBO;
import com.chanchal.futurestradeservice.to.FuturesTradesTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SimpleMapper {

    SimpleMapper INSTANCE = Mappers.getMapper(SimpleMapper.class);

    FuturesTradesBO FuturesTradesTOToFuturesTradesBO(FuturesTradesTO source);
}