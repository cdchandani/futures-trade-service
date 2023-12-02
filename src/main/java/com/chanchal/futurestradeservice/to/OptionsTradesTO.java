package com.chanchal.futurestradeservice.to;

import lombok.Builder;
import lombok.Getter;

///home/hp/dev/work/FinancialData/option_trades/option_stock_dump_file.csv
@Getter
@Builder
public class OptionsTradesTO {

    private String oi;
    private String oiChange;
    private String volume;
    private String chgInLtp;
    private String ltp;
    private String strikePrice;
    private String ltp1;
    private String chgInLtp1;
    private String volume1;
    private String oiChange1;
    private String oi1;
    private String symbol;
    private String mcSymbol;
    private String undrlngSt;
    private String expiry;
    private String extractionDt;

}
