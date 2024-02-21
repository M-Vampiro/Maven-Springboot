package com.vtxlab.bootcamp.stockpriceboard.DTO.JPH;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class QuoteDTO {

  private double c;

  private double d;

  private double dp;

  private double h;

  private double l;

  private double o;

  private double pc;

}
