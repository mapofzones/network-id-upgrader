package com.mapofzones.networkidupgrader.data.repository;

import com.mapofzones.networkidupgrader.data.entities.IBCTransferHourlyStat;
import com.mapofzones.networkidupgrader.data.entities.ZoneParameter;
import com.mapofzones.networkidupgrader.data.entities.keys.IBCTransferHourlyStatsKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface IBCTransferHourlyStatsRepository extends JpaRepository<IBCTransferHourlyStat, IBCTransferHourlyStatsKey> {
    List<IBCTransferHourlyStat> findAllByZone(String zone);
}
