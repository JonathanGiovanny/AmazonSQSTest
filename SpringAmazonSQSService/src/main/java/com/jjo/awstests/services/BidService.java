package com.jjo.awstests.services;

import com.jjo.awstests.model.BidEntity;

public interface BidService {

  void saveBid(BidEntity bidEntity);

  void sendBid(BidEntity bidEntity);

}
