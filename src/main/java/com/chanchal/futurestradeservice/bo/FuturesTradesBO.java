package com.chanchal.futurestradeservice.bo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "tbl_futures_trades", schema = "futures")
@Getter
@Setter
@ToString
public class FuturesTradesBO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private Long orderId;
	private String contractDate;
	private String previousS;
	private String openPrice;
	private String highPrice;
	private String lowPrice;
	private String closePric;
	private String settlement;
	private String netChange;
	private String oiNoCon;
	private String tradedQty;
	private String tradedVolume;
	private String tradedVal;
	private String expiry;
	private String symbol;
	private String extractionDate;
	private String brokerClient;
	@CreationTimestamp
	private Timestamp createdDt;
	@CreationTimestamp
	private Timestamp modifiedDt;
}
