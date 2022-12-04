package com.mapofzones.networkidupgrader.data.entities;

import com.mapofzones.networkidupgrader.data.entities.keys.TokenPriceKey;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@IdClass(TokenPriceKey.class)
@Table(name = "token_prices", schema = "public")
public class TokenPrice {
    @Id
    @Column(name = "zone")
    @NonNull
    private String zone;

    @Id
    @Column(name = "base_denom")
    @NonNull
    private String baseDenom;

    @Id
    @Column(name = "datetime")
    @NonNull
    private LocalDateTime datetime;

    @Column(name = "coingecko_symbol_price_in_usd")
    private Double coingeckoSymbolPriceInUsd;

    @Column(name = "osmosis_symbol_price_in_usd")
    private Double osmosisSymbolPriceInUsd;

    @Column(name = "sifchain_symbol_price_in_usd")
    private Double sifchainSymbolPriceInUsd;

    @Column(name = "coingecko_symbol_market_cap_in_usd")
    private Double coingeckoSymbolMarketCapInUsd;

    @Column(name = "coingecko_symbol_total_volumes_in_usd")
    private Double coingeckoSymbolTotalVolumesInUsd;

    @Column(name = "symbol_supply")
    private Double symbolSupply;

    public TokenPrice() {
    }

    public TokenPrice(@NonNull String zone) {
        this.zone = zone;
    }

    public void fillDataFields(TokenPrice token) {
        this.baseDenom = token.baseDenom;
        this.datetime = token.datetime;
        this.coingeckoSymbolPriceInUsd = token.coingeckoSymbolPriceInUsd;
        this.osmosisSymbolPriceInUsd = token.osmosisSymbolPriceInUsd;
        this.sifchainSymbolPriceInUsd = token.sifchainSymbolPriceInUsd;
        this.coingeckoSymbolMarketCapInUsd = token.coingeckoSymbolMarketCapInUsd;
        this.coingeckoSymbolTotalVolumesInUsd = token.coingeckoSymbolTotalVolumesInUsd;
        this.symbolSupply = token.symbolSupply;
    }

    @Override
    public String toString() {
        return "TokenPrice{" +
                "zone='" + zone + '\'' +
                ", baseDenom='" + baseDenom + '\'' +
                ", datetime=" + datetime +
                ", coingeckoSymbolPriceInUsd=" + coingeckoSymbolPriceInUsd +
                ", osmosisSymbolPriceInUsd=" + osmosisSymbolPriceInUsd +
                ", sifchainSymbolPriceInUsd=" + sifchainSymbolPriceInUsd +
                ", coingeckoSymbolMarketCapInUsd=" + coingeckoSymbolMarketCapInUsd +
                ", coingeckoSymbolTotalVolumesInUsd=" + coingeckoSymbolTotalVolumesInUsd +
                ", symbolSupply=" + symbolSupply +
                '}';
    }
}
