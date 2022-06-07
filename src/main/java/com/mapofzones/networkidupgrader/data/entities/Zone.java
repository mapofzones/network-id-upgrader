package com.mapofzones.networkidupgrader.data.entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;

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

    @Override
    public String toString() {
        return "Zone{" +
                "chainId='" + chainId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
