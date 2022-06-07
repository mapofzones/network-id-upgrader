package com.mapofzones.networkidupgrader.data.entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@IdClass(IbcChannelsKey.class)
@Table(name = "ibc_channels", schema = "public")
public class IbcChannels {
    @Id
    @Column(name = "zone")
    @NonNull
    private String zone;

    @Id
    @Column(name = "channel_id")
    @NonNull
    private String channelId;

    @Column(name = "connection_id")
    @NonNull
    private String connectionId;

    @Column(name = "is_opened")
    @NonNull
    private Boolean isOpened;

    @Column(name = "added_at")
    @NonNull
    private LocalDateTime addedAt;

    @Column(name = "counterparty_channel_id")
    private String counterpartyChannelId;

    public IbcChannels() {
    }

    public IbcChannels(@NonNull String zone) {
        this.zone = zone;
    }

    public void fillDataFields(IbcChannels ibcChannels) {
        this.channelId = ibcChannels.channelId;
        this.connectionId = ibcChannels.connectionId;
        this.isOpened = ibcChannels.isOpened;
        this.addedAt = ibcChannels.addedAt;
        this.counterpartyChannelId = ibcChannels.counterpartyChannelId;
    }

    @Override
    public String toString() {
        return "IbcChannels{" +
                "zone='" + zone + '\'' +
                ", channelId='" + channelId + '\'' +
                ", connectionId='" + connectionId + '\'' +
                ", isOpened=" + isOpened +
                ", addedAt=" + addedAt +
                ", counterpartyChannelId='" + counterpartyChannelId + '\'' +
                '}';
    }
}
