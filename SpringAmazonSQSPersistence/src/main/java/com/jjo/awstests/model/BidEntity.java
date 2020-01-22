package com.jjo.awstests.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class BidEntity implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -3819797149212942768L;

  @Id
  private Long id;
  private String name;
  private BigDecimal price;
}
