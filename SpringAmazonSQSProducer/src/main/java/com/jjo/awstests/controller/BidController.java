package com.jjo.awstests.controller;

import javax.validation.Valid;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jjo.awstests.controller.validator.BidValidator;
import com.jjo.awstests.dto.Bid;
import com.jjo.awstests.mapper.BidMapper;
import com.jjo.awstests.services.BidService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/bid")
@RequiredArgsConstructor
public class BidController {

  private @NonNull BidValidator bidValidator;
  private @NonNull BidService bidService;
  private @NonNull BidMapper bidMapper;

  @InitBinder("Bid")
  protected void initBinder(WebDataBinder binder) {
    binder.addValidators(bidValidator);
  }

  @PutMapping("/{id}")
  public void pushBidIntoQueue(@PathVariable Long id, @Valid @RequestBody Bid bid) {
     bid.setId(id);
     bidService.sendBid(bidMapper.dtoToEntity(bid));
  }
}
