package com.mapofzones.networkidupgrader.data.repository;

import com.mapofzones.networkidupgrader.data.entities.ZoneParameter;
import com.mapofzones.networkidupgrader.data.entities.keys.ZoneParameterKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface ZoneParametersRepository extends JpaRepository<ZoneParameter, ZoneParameterKey> {
    List<ZoneParameter> findAllByZone(String zone);
}
