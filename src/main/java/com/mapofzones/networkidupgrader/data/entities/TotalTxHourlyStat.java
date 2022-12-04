package com.mapofzones.networkidupgrader.data.entities;

import com.mapofzones.networkidupgrader.data.entities.keys.TotalTxHourlyStatKey;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@IdClass(TotalTxHourlyStatKey.class)
@Table(name = "total_tx_hourly_stats", schema = "public")
public class TotalTxHourlyStat {
    @Id
    @Getter
    @Setter
    @Column(name = "zone")
    @NonNull
    private String zone;

    @Id
    @Column(name = "hour")
    @NonNull
    private LocalDateTime hour;

    @Id
    @Column(name = "period")
    @NonNull
    private Integer period;

    @Getter
    @Setter
    @Column(name = "txs_cnt")
    @NonNull
    private Integer txsCnt;

    @Getter
    @Setter
    @Column(name = "txs_w_ibc_xfer_cnt")
    @NonNull
    private BigInteger txsWIbcXferCnt;

    @Getter
    @Setter
    @Column(name = "txs_w_ibc_xfer_fail_cnt")
    @NonNull
    private BigInteger txsWIbcXferFailCnt;

    @Getter
    @Setter
    @Column(name = "total_coin_turnover_amount")
    @NonNull
    private Double totalCoinTurnoverAmount;

    public TotalTxHourlyStat() {
    }

    public TotalTxHourlyStat(@NonNull String zone) {
        this.zone = zone;
    }

    public void fillDataFields(TotalTxHourlyStat totalTxHourlyStat) {
        this.hour = totalTxHourlyStat.hour;
        this.period = totalTxHourlyStat.period;
        this.txsCnt = totalTxHourlyStat.txsCnt;
        this.txsWIbcXferCnt = totalTxHourlyStat.txsWIbcXferCnt;
        this.txsWIbcXferFailCnt = totalTxHourlyStat.txsWIbcXferFailCnt;
        this.totalCoinTurnoverAmount = totalTxHourlyStat.totalCoinTurnoverAmount;
    }

    @Override
    public String toString() {
        return "TotalTxHourlyStat{" +
                "zone='" + zone + '\'' +
                ", hour=" + hour +
                ", period=" + period +
                ", txsCnt=" + txsCnt +
                ", txsWIbcXferCnt=" + txsWIbcXferCnt +
                ", txsWIbcXferFailCnt=" + txsWIbcXferFailCnt +
                ", totalCoinTurnoverAmount=" + totalCoinTurnoverAmount +
                '}';
    }
}
