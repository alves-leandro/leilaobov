package com.bovauction.bovwallet.repository;

import com.bovauction.bovwallet.model.CardInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardInfoRepository extends JpaRepository<CardInfo, Long> {
    List<CardInfo> findByClient_Id(Long clientId);
}
