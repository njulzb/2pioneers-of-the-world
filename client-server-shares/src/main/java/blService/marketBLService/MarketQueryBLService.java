package blService.marketBLService;

import resultMsg.MarketResultMsg;

import java.util.Date;

public interface MarketQueryBLService {
    MarketResultMsg queryMarketByDate(Date date);
}
