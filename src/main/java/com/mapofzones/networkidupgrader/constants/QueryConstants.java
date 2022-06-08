package com.mapofzones.networkidupgrader.constants;

public interface QueryConstants {
    String GET_NUMBER_OF_TOTAL_TX_HOURLY_STATS_COLLISIONS = "" +
        "select\n" +
        "    count(*)\n" +
        "from\n" +
        "    total_tx_hourly_stats as previous\n" +
        "left join total_tx_hourly_stats as current\n" +
        "    on previous.hour = current.hour\n" +
        "where\n" +
        "    previous.zone = :zone_old\n" +
        "    and current.zone = :zone_new";
}
