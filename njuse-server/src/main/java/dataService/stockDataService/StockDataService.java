package dataService.stockDataService;


import utility.poResultMsg.StockPOResultMsg;

import java.util.Date;

public interface StockDataService {
    StockPOResultMsg searchStockByCode(String code);
    StockPOResultMsg searchStockByName(String name);
    StockPOResultMsg searchStockByMarket(String market);
    StockPOResultMsg searchStockByCodeAndDate(String code,Date begin ,Date end);
    StockPOResultMsg searchStockByNameAndDate(String name,Date begin,Date end);
}
