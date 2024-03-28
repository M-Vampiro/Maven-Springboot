package com.vtxlab.bootcamp.cryptopricefetcher.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vtxlab.bootcamp.cryptopricefetcher.DTO.CoinDTO;
import com.vtxlab.bootcamp.cryptopricefetcher.Model.Coin;

@Component
public class Mapper {

  @Autowired
  private ModelMapper modelMapper;

  public CoinDTO map(Coin coin) {
    return this.modelMapper.map(coin, CoinDTO.class);
  }

  public CoinDTO mapEntity(Coin coin) {
    CoinDTO.Roi roi = coin.getRoi() == null ? null
        : CoinDTO.Roi.builder().times(coin.getRoi().getTimes()).currency(coin.getRoi().getCurrency())
            .percentage(coin.getRoi().getPercentage()).build();

    return CoinDTO.builder()
        .id(coin.getId())
        .symbol(coin.getSymbol())
        .name(coin.getName())
        .image(coin.getImage())
        .current_price(coin.getCurrent_price())
        .market_cap(coin.getMarket_cap())
        .market_cap_rank(coin.getMarket_cap_rank())
        .fully_diluted_valuation(coin.getFully_diluted_valuation())
        .total_volume(coin.getTotal_volume())
        .high_24h(coin.getHigh_24h())
        .low_24h(coin.getLow_24h())
        .price_change_24h(coin.getPrice_change_24h())
        .price_change_percentage_24h(coin.getPrice_change_percentage_24h())
        .market_cap_change_24h(coin.getMarket_cap_change_24h())
        .market_cap_change_percentage_24h(coin.getMarket_cap_change_percentage_24h())
        .circulating_supply(coin.getCirculating_supply())
        .total_supply(coin.getTotal_supply())
        .max_supply(coin.getMax_supply())
        .ath(coin.getAth())
        .ath_change_percentage(coin.getAth_change_percentage())
        .ath_date(coin.getAth_date())
        .atl(coin.getAtl())
        .atl_change_percentage(coin.getAtl_change_percentage())
        .atl_date(coin.getAtl_date())
        .roi(roi)
        .last_updated(coin.getLast_updated())
        .build();
  }
}
