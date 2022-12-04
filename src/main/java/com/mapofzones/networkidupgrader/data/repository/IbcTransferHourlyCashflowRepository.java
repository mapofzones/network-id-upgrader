package com.mapofzones.networkidupgrader.data.repository;

import com.mapofzones.networkidupgrader.data.entities.IbcTransferHourlyCashflow;
import com.mapofzones.networkidupgrader.data.entities.keys.IbcTransferHourlyCashflowKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface IbcTransferHourlyCashflowRepository extends JpaRepository<IbcTransferHourlyCashflow, IbcTransferHourlyCashflowKey> {
    List<IbcTransferHourlyCashflow> findAllByZone(String zone);
}
