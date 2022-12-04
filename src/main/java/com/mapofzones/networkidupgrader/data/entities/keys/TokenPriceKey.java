package com.mapofzones.networkidupgrader.data.entities.keys;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TokenPriceKey implements Serializable {
    private String zone;
    private String baseDenom;
    private LocalDateTime datetime;
}
