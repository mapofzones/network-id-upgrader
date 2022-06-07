package com.mapofzones.networkidupgrader.data.entities;

import com.google.common.base.Strings;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "zones", schema = "public")
public class Zone {
    @Id
    @Column(name = "chain_id")
    @NonNull
    private String chainId;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_enabled")
    @NonNull
    private Boolean isEnabled;

    @Column(name = "added_at")
    @NonNull
    private LocalDateTime addedAt;

    @Column(name = "is_caught_up")
    @NonNull
    private Boolean isCaughtUp;

    @Column(name = "updated_at")
    @NonNull
    private LocalDateTime updatedAt;

    @Column(name = "is_mainnet")
    @NonNull
    private Boolean isMainnet;

    @Column(name = "is_zone_new")
    @NonNull
    private Boolean isZoneNew;

    @Column(name = "zone_label_url")
    private String zoneLabelUrl;

    @Column(name = "zone_label_url2")
    private String zoneLabelUrl2;

    @Column(name = "website")
    private String website;

    @Column(name = "is_active_addresses_hidden")
    @NonNull
    private Boolean isActiveAddressesHidden;

    public void fillDefaultFields(Zone zone) {
        if (this.name.equals(this.chainId))
            this.name = zone.name;
        if (Strings.isNullOrEmpty(this.description))
            this.description = zone.description;
        if (!this.isEnabled)
            this.isEnabled = zone.isEnabled;
        if (this.addedAt.isAfter(zone.addedAt))
            this.addedAt = zone.addedAt;
        if (!this.isCaughtUp)
            this.isCaughtUp = zone.isCaughtUp;
        this.updatedAt = LocalDateTime.now();
//        if (!this.isMainnet)
//            this.isMainnet = zone.isMainnet;
        if (!this.isZoneNew)
            this.isZoneNew = zone.isZoneNew;
        if (Strings.isNullOrEmpty(this.zoneLabelUrl))
            this.zoneLabelUrl = zone.zoneLabelUrl;
        if (Strings.isNullOrEmpty(this.zoneLabelUrl2))
            this.zoneLabelUrl2 = zone.zoneLabelUrl2;
        if (Strings.isNullOrEmpty(this.website))
            this.website = zone.website;
        if (!this.isActiveAddressesHidden)
            this.isActiveAddressesHidden = zone.isActiveAddressesHidden;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "chainId='" + chainId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isEnabled=" + isEnabled +
                ", addedAt=" + addedAt +
                ", isCaughtUp=" + isCaughtUp +
                ", updatedAt=" + updatedAt +
                ", isMainnet=" + isMainnet +
                ", isZoneNew=" + isZoneNew +
                ", zoneLabelUrl='" + zoneLabelUrl + '\'' +
                ", zoneLabelUrl2='" + zoneLabelUrl2 + '\'' +
                ", website='" + website + '\'' +
                ", isActiveAddressesHidden=" + isActiveAddressesHidden +
                '}';
    }
}
