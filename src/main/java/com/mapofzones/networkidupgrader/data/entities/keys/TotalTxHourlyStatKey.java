package com.mapofzones.networkidupgrader.data.entities.keys;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TotalTxHourlyStatKey implements Serializable {
    private String zone;
    private LocalDateTime hour;
    private Integer period;
}
