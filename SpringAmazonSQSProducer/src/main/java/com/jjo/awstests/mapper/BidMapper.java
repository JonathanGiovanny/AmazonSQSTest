package com.jjo.h2.mapper;

import org.mapstruct.Mapper;
import com.jjo.h2.dto.Bid;
import com.jjo.h2.model.BidEntity;

@Mapper(componentModel = "spring")
public interface BidMapper {

  BidEntity dtoToEntity(Bid bid);
  
  Bid entityToDto(BidEntity entity);
}
