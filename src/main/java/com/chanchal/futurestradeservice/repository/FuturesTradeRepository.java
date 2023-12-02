package com.chanchal.futurestradeservice.repository;

import com.chanchal.futurestradeservice.bo.FuturesTradesBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuturesTradeRepository extends JpaRepository<FuturesTradesBO, Long> {

}
