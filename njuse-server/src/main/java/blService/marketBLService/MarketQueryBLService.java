package blService.marketBLService;

import utility.resultMsg.voResultMsg.MarketResultMsg;

import java.util.Date;

public interface MarketQueryBLService {
    public MarketResultMsg queryMarketByDate(Date date);
}
