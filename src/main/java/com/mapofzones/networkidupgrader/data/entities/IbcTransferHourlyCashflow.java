package com.mapofzones.networkidupgrader.data.entities;

import com.mapofzones.networkidupgrader.data.entities.keys.IbcTransferHourlyCashflowKey;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@IdClass(IbcTransferHourlyCashflowKey.class)
@Table(name = "ibc_transfer_hourly_cashflow", schema = "public")
public class IbcTransferHourlyCashflow {
    @Id
    @Column(name = "zone")
    @NonNull
    private String zone;

    @Id
    @Column(name = "zone_src")
    @NonNull
    private String zoneSrc;

    @Id
    @Column(name = "zone_dest")
    @NonNull
    private String zoneDest;

    @Id
    @Column(name = "hour")
    @NonNull
    private LocalDateTime hour;

    @Id
    @Column(name = "period")
    @NonNull
    private Integer period;

    @Id
    @Column(name = "ibc_channel")
    @NonNull
    private String ibcChannel;

    @Id
    @Column(name = "denom")
    @NonNull
    private String denom;

    @Column(name = "amount")
    @NonNull
    private Double amount;

    @Column(name = "derivative_denom")
    private String derivativeDenom;

    public IbcTransferHourlyCashflow() {
    }

    public IbcTransferHourlyCashflow(@NonNull String zone) {
        this.zone = zone;
    }

    public void fillDataFields(IbcTransferHourlyCashflow ibcTransferHourlyCashflow) {
        this.zoneSrc = ibcTransferHourlyCashflow.zoneSrc;
        this.zoneDest = ibcTransferHourlyCashflow.zoneDest;
        this.hour = ibcTransferHourlyCashflow.hour;
        this.period = ibcTransferHourlyCashflow.period;
        this.ibcChannel = ibcTransferHourlyCashflow.ibcChannel;
        this.denom = ibcTransferHourlyCashflow.denom;
        this.amount = ibcTransferHourlyCashflow.amount;
        this.derivativeDenom = ibcTransferHourlyCashflow.derivativeDenom;
    }

    @Override
    public String toString() {
        return "IbcTransferHourlyCashflow{" +
                "zone='" + zone + '\'' +
                ", zoneSrc='" + zoneSrc + '\'' +
                ", zoneDest='" + zoneDest + '\'' +
                ", hour=" + hour +
                ", period=" + period +
                ", ibcChannel='" + ibcChannel + '\'' +
                ", denom='" + denom + '\'' +
                ", amount=" + amount +
                ", derivativeDenom='" + derivativeDenom + '\'' +
                '}';
    }
}
