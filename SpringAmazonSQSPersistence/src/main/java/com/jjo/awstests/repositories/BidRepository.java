package com.jjo.awstests.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jjo.awstests.model.BidEntity;

public interface BidRepository extends JpaRepository<BidEntity, Long> {

}
