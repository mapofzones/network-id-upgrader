package com.mapofzones.networkidupgrader.data.entities;

import com.mapofzones.networkidupgrader.data.entities.keys.IbcClientsKey;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@IdClass(IbcClientsKey.class)
@Table(name = "ibc_clients", schema = "public")
public class IbcClients {
    @Id
    @Column(name = "zone")
    @NonNull
    private String zone;

    @Id
    @Column(name = "client_id")
    @NonNull
    private String clientId;

    @Getter
    @Setter
    @Column(name = "chain_id")
    @NonNull
    private String chainId;

    @Column(name = "added_at")
    @NonNull
    private LocalDateTime addedAt;

    public IbcClients() {
    }

    public IbcClients(@NonNull String zone) {
        this.zone = zone;
    }

    public void fillDataFields(IbcClients ibcClients) {
        this.clientId = ibcClients.clientId;
        this.chainId = ibcClients.chainId;
        this.addedAt = ibcClients.addedAt;
    }

    @Override
    public String toString() {
        return "IbcClients{" +
                "zone='" + zone + '\'' +
                ", clientId='" + clientId + '\'' +
                ", chainId='" + chainId + '\'' +
                ", addedAt=" + addedAt +
                '}';
    }
}
