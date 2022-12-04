package com.mapofzones.networkidupgrader.data.repository;

import com.mapofzones.networkidupgrader.data.entities.TokenPrice;
import com.mapofzones.networkidupgrader.data.entities.keys.TokenPriceKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface TokenPricesRepository extends JpaRepository<TokenPrice, TokenPriceKey> {
    List<TokenPrice> findAllByZone(String zone);
}
