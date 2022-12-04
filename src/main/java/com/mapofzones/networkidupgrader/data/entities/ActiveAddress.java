package com.mapofzones.networkidupgrader.data.entities;

import com.mapofzones.networkidupgrader.data.entities.keys.ActiveAddressKey;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@IdClass(ActiveAddressKey.class)
@Table(name = "active_addresses", schema = "public")
public class ActiveAddress {
    @Id
    @Getter
    @Setter
    @Column(name = "address")
    @NonNull
    private String address;

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
    @Column(name = "is_internal_tx")
    private Boolean isInternalTx;

    @Getter
    @Setter
    @Column(name = "is_internal_transfer")
    private Boolean isInternalTransfer;

    @Getter
    @Setter
    @Column(name = "is_external_transfer")
    private Boolean isExternalTransfer;

    public ActiveAddress() {
    }

    public ActiveAddress(@NonNull String zone) {
        this.zone = zone;
    }

    public void fillDataFields(ActiveAddress totalTxHourlyStat) {
        this.address = totalTxHourlyStat.address;
        this.hour = totalTxHourlyStat.hour;
        this.period = totalTxHourlyStat.period;
        this.isInternalTx = totalTxHourlyStat.isInternalTx;
        this.isInternalTransfer = totalTxHourlyStat.isInternalTransfer;
        this.isExternalTransfer = totalTxHourlyStat.isExternalTransfer;
    }

    @Override
    public String toString() {
        return "ActiveAddress{" +
                "address='" + address + '\'' +
                ", zone='" + zone + '\'' +
                ", hour=" + hour +
                ", period=" + period +
                ", isInternalTx=" + isInternalTx +
                ", isInternalTransfer=" + isInternalTransfer +
                ", isExternalTransfer=" + isExternalTransfer +
                '}';
    }
}
