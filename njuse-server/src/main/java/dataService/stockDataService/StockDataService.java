package dataService.stockDataService;


import utility.poResultMsg.StockPOResultMsg;

import java.util.Date;

public interface StockDataService {
    public StockPOResultMsg searchStockByCode(String code);
    public StockPOResultMsg searchStockByName(String name);
    public StockPOResultMsg searchStockByMarket(String market);
    public StockPOResultMsg searchStockByCodeAndDate(String code,Date begin ,Date end);
}
