package com.mapofzones.networkidupgrader.data.entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@IdClass(IbcConnectionsKey.class)
@Table(name = "ibc_connections", schema = "public")
public class IbcConnections {
    @Id
    @Column(name = "zone")
    @NonNull
    private String zone;

    @Id
    @Column(name = "connection_id")
    @NonNull
    private String connectionId;

    @Column(name = "client_id")
    @NonNull
    private String clientId;

    @Column(name = "added_at")
    @NonNull
    private LocalDateTime addedAt;

    public IbcConnections() {
    }

    public IbcConnections(@NonNull String zone) {
        this.zone = zone;
    }

    public void fillDataFields(IbcConnections ibcConnections) {
        this.connectionId = ibcConnections.connectionId;
        this.clientId = ibcConnections.clientId;
        this.addedAt = ibcConnections.addedAt;
    }

    @Override
    public String toString() {
        return "IbcConnections{" +
                "zone='" + zone + '\'' +
                ", connectionId='" + connectionId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", addedAt=" + addedAt +
                '}';
    }
}
