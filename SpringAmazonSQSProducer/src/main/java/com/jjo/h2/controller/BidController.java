package com.jjo.h2.controller;

import javax.validation.Valid;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jjo.h2.controller.validator.BidValidator;
import com.jjo.h2.dto.Bid;
import com.jjo.h2.mapper.BidMapper;
import com.jjo.h2.services.BidService;
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
