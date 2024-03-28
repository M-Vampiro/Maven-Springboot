package com.vtxlab.bootcamp.stockprofilefetcher.DTO.JPH;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class QuoteDTO {

  private Double c;

  private Double d;

  private Double dp;

  private Double h;

  private Double l;

  private Double o;

  private Double pc;

}
