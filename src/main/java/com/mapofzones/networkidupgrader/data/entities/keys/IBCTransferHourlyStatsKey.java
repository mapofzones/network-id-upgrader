package com.mapofzones.networkidupgrader.data.entities.keys;

import java.io.Serializable;
import java.time.LocalDateTime;

public class IBCTransferHourlyStatsKey implements Serializable {
    private String zone;
    private String zoneSource;
    private String zoneDestination;
    private LocalDateTime hour;
}
