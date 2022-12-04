package com.mapofzones.networkidupgrader.data.entities;

import com.mapofzones.networkidupgrader.data.entities.keys.DerivativeKey;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@IdClass(DerivativeKey.class)
@Table(name = "derivatives", schema = "public")
public class Derivative {
    @Id
    @Column(name = "zone")
    @NonNull
    private String zone;

    @Id
    @Column(name = "full_denom")
    @NonNull
    private String fullDenom;

    @Column(name = "base_denom")
    private String baseDenom;

    @Column(name = "origin_zone")
    private String originZone;

    public Derivative() {
    }

    public Derivative(@NonNull String zone) {
        this.zone = zone;
    }

    public void fillDataFields(Derivative token) {
        this.baseDenom = token.baseDenom;
        this.fullDenom = token.fullDenom;
        this.originZone = token.originZone;
    }

    @Override
    public String toString() {
        return "Derivative{" +
                "zone='" + zone + '\'' +
                ", fullDenom='" + fullDenom + '\'' +
                ", baseDenom='" + baseDenom + '\'' +
                ", originZone='" + originZone + '\'' +
                '}';
    }
}
