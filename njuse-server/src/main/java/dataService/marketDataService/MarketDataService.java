package dataService.marketDataService;

import utility.poResultMsg.MarketPOResultMsg;

import java.util.Date;

public interface MarketDataService {
    MarketPOResultMsg getStocksIn2Days(Date today);
}
