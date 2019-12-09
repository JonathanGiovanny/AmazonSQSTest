package com.jjo.h2.services;

import org.springframework.stereotype.Service;
import com.jjo.h2.model.BidEntity;
import com.jjo.h2.repositories.BidRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BidServiceImpl implements BidService {

  private @NonNull BidRepository bidRepository;

  @Override
  public void saveBid(BidEntity bidEntity) {
    log.info("Saving Bid {}", bidEntity);
    bidRepository.save(bidEntity);
  }

  @Override
  public void sendBid(BidEntity bidEntity) {
    log.info("Sending Bid to Amazon SQS Queue: {}", bidEntity);
  }
}
