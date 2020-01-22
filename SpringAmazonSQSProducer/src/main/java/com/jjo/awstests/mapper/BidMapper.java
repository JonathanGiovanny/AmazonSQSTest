package com.jjo.awstests.mapper;

import org.mapstruct.Mapper;
import com.jjo.awstests.dto.Bid;
import com.jjo.awstests.model.BidEntity;

@Mapper(componentModel = "spring")
public interface BidMapper {

  BidEntity dtoToEntity(Bid bid);
  
  Bid entityToDto(BidEntity entity);
}
