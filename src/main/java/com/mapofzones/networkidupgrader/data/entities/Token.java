package com.mapofzones.networkidupgrader.data.entities;

import com.mapofzones.networkidupgrader.data.entities.keys.TokenKey;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@IdClass(TokenKey.class)
@Table(name = "tokens", schema = "public")
public class Token {
    @Id
    @Column(name = "zone")
    @NonNull
    private String zone;

    @Id
    @Column(name = "base_denom")
    @NonNull
    private String baseDenom;

    @Column(name = "coingecko_id")
    private String coingeckoId;

    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "osmosis_id")
    private String osmosisId;

    @Column(name = "sifchain_id")
    private String sifchainId;

    @Column(name = "price_last_checked_at")
    private LocalDateTime priceLastCheckedAt;

    @Column(name = "symbol_point_exponent")
    private Integer symbolPointExponent;

    @Column(name = "is_price_ignored")
    private Boolean isPriceIgnored;

    public Token() {
    }

    public Token(@NonNull String zone) {
        this.zone = zone;
    }

    public void fillDataFields(Token token) {
        this.baseDenom = token.baseDenom;
        this.coingeckoId = token.coingeckoId;
        this.logoUrl = token.logoUrl;
        this.symbol = token.symbol;
        this.osmosisId = token.osmosisId;
        this.sifchainId = token.sifchainId;
        this.priceLastCheckedAt = token.priceLastCheckedAt;
        this.symbolPointExponent = token.symbolPointExponent;
        this.isPriceIgnored = token.isPriceIgnored;
    }

    @Override
    public String toString() {
        return "Token{" +
                "zone='" + zone + '\'' +
                ", baseDenom='" + baseDenom + '\'' +
                ", coingeckoId='" + coingeckoId + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", symbol='" + symbol + '\'' +
                ", osmosisId='" + osmosisId + '\'' +
                ", sifchainId='" + sifchainId + '\'' +
                ", priceLastCheckedAt=" + priceLastCheckedAt +
                ", symbolPointExponent=" + symbolPointExponent +
                ", isPriceIgnored=" + isPriceIgnored +
                '}';
    }
}
