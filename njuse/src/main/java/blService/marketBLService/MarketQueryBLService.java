package blService.marketBLService;

import utility.resultMsg.MarketResultMsg;

import java.util.Date;

public interface MarketQueryBLService {
    public MarketResultMsg queryMarketByDate(Date date);
}
