package com.jjo.h2.services;

import com.jjo.h2.model.BidEntity;

public interface BidService {

  void saveBid(BidEntity bidEntity);

  void sendBid(BidEntity bidEntity);

}
