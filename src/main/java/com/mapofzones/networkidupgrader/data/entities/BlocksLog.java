package com.mapofzones.networkidupgrader.data.entities;

import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "blocks_log", schema = "public")
public class BlocksLog {
    @Id
    @Column(name = "zone")
    @NonNull
    private String zone;

    @Column(name = "last_processed_block")
    @NonNull
    private Integer lastProcessedBlock;

    @Column(name = "last_updated_at")
    @NonNull
    private LocalDateTime lastUpdatedAt;

    public BlocksLog() {
    }

    public BlocksLog(@NonNull String zone) {
        this.zone = zone;
    }

    public void fillDataFields(BlocksLog blocksLog) {
        this.lastProcessedBlock = blocksLog.lastProcessedBlock;
        this.lastUpdatedAt = blocksLog.lastUpdatedAt;
    }

    @Override
    public String toString() {
        return "BlocksLog{" +
                "zone='" + zone + '\'' +
                ", lastProcessedBlock=" + lastProcessedBlock +
                ", lastUpdatedAt=" + lastUpdatedAt +
                '}';
    }
}
