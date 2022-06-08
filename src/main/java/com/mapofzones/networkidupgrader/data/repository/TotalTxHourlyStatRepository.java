package com.mapofzones.networkidupgrader.data.repository;

import com.mapofzones.networkidupgrader.constants.QueryConstants;
import com.mapofzones.networkidupgrader.data.entities.TotalTxHourlyStat;
import com.mapofzones.networkidupgrader.data.entities.keys.TotalTxHourlyStatKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface TotalTxHourlyStatRepository extends JpaRepository<TotalTxHourlyStat, TotalTxHourlyStatKey> {
    List<TotalTxHourlyStat> findAllByZone(String zone);

    @Query(value = QueryConstants.GET_NUMBER_OF_TOTAL_TX_HOURLY_STATS_COLLISIONS, nativeQuery = true)
    long countMergeCollisions(@Param("zone_old") String zoneOld, @Param("zone_new") String zoneNew);
}
