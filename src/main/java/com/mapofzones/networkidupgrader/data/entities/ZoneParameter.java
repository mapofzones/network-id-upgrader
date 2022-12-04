package com.mapofzones.networkidupgrader.data.entities;

import com.mapofzones.networkidupgrader.data.entities.keys.ZoneParameterKey;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@IdClass(ZoneParameterKey.class)
@Table(name = "zone_parameters", schema = "public")
public class ZoneParameter {
    @Id
    @Column(name = "zone")
    @NonNull
    private String zone;

    @Id
    @Column(name = "datetime")
    @NonNull
    private LocalDateTime datetime;

    @Column(name = "active_validators_quantity")
    private Integer activeValidatorsQuantity;

    @Column(name = "amount_of_bonded")
    private Double amountOfBonded;

    @Column(name = "unbound_period")
    private Integer unboundPeriod;

    @Column(name = "inflation")
    private Double inflation;

    public ZoneParameter() {
    }

    public ZoneParameter(@NonNull String zone) {
        this.zone = zone;
    }

    public void fillDataFields(ZoneParameter zoneParameter) {
        this.datetime = zoneParameter.datetime;
        this.activeValidatorsQuantity = zoneParameter.activeValidatorsQuantity;
        this.amountOfBonded = zoneParameter.amountOfBonded;
        this.unboundPeriod = zoneParameter.unboundPeriod;
        this.inflation = zoneParameter.inflation;
    }

    @Override
    public String toString() {
        return "ZoneParameter{" +
                "zone='" + zone + '\'' +
                ", datetime=" + datetime +
                ", activeValidatorsQuantity=" + activeValidatorsQuantity +
                ", amountOfBonded=" + amountOfBonded +
                ", unboundPeriod=" + unboundPeriod +
                ", inflation=" + inflation +
                '}';
    }
}
