package com.mapofzones.networkidupgrader.data.entities;

import com.mapofzones.networkidupgrader.data.entities.keys.IBCTransferHourlyStatsKey;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@IdClass(IBCTransferHourlyStatsKey.class)
@Table(name = "ibc_transfer_hourly_stats", schema = "public")
public class IBCTransferHourlyStat {
    @Id
    @Column(name = "zone")
    @NonNull
    private String zone;

    @Id
    @Column(name = "zone_src")
    @NonNull
    private String zoneSource;

    @Id
    @Column(name = "zone_dest")
    @NonNull
    private String zoneDestination;

    @Id
    @Column(name = "hour")
    @NonNull
    private LocalDateTime hour;

    @Column(name = "txs_cnt")
    private Integer txsCount;

    @Column(name = "period")
    private Integer period;

    @Column(name = "txs_fail_cnt")
    private Integer txsFailCount;

    @Column(name = "ibc_channel")
    @NonNull
    private String ibcChannel;

    public IBCTransferHourlyStat() {
    }

    public IBCTransferHourlyStat(@NonNull String zone) {
        this.zone = zone;
    }

    public void fillDataFields(IBCTransferHourlyStat ibcTransferHourlyStat) {
        this.zoneSource = ibcTransferHourlyStat.zoneSource;
        this.zoneDestination = ibcTransferHourlyStat.zoneDestination;
        this.hour = ibcTransferHourlyStat.hour;
        this.txsCount = ibcTransferHourlyStat.txsCount;
        this.period = ibcTransferHourlyStat.period;
        this.txsFailCount = ibcTransferHourlyStat.txsFailCount;
        this.ibcChannel = ibcTransferHourlyStat.ibcChannel;
    }

    @Override
    public String toString() {
        return "IBCTransferHourlyStat{" +
                "zone='" + zone + '\'' +
                ", zoneSource='" + zoneSource + '\'' +
                ", zoneDestination='" + zoneDestination + '\'' +
                ", hour=" + hour +
                ", txsCount=" + txsCount +
                ", period=" + period +
                ", txsFailCount=" + txsFailCount +
                ", ibcChannel='" + ibcChannel + '\'' +
                '}';
    }
}
