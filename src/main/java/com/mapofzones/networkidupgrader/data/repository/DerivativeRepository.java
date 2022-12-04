package com.mapofzones.networkidupgrader.data.repository;

import com.mapofzones.networkidupgrader.data.entities.Derivative;
import com.mapofzones.networkidupgrader.data.entities.keys.DerivativeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface DerivativeRepository extends JpaRepository<Derivative, DerivativeKey> {
    List<Derivative> findAllByZone(String zone);
}
