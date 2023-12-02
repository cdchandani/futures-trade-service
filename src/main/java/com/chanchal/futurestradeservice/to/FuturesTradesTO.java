package com.chanchal.futurestradeservice.to;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

///home/hp/dev/work/FinancialData/future_trades/nse_future_stock_25Jan2023_sample.csv
@Getter
@ToString
@NoArgsConstructor
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FuturesTradesTO {

	private long id;
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

}
