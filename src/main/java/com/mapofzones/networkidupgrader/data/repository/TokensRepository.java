package com.mapofzones.networkidupgrader.data.repository;

import com.mapofzones.networkidupgrader.data.entities.Token;
import com.mapofzones.networkidupgrader.data.entities.keys.TokenKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface TokensRepository extends JpaRepository<Token, TokenKey> {
    List<Token> findAllByZone(String zone);
}
