package com.mapofzones.networkidupgrader.data.entities.keys;

import java.io.Serializable;
import java.time.LocalDateTime;

public class IbcTransferHourlyCashflowKey implements Serializable {
    private String zone;
    private String zoneSrc;
    private String zoneDest;
    private LocalDateTime hour;
    private Integer period;
    private String ibcChannel;
    private String denom;
}
