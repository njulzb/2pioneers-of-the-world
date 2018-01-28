package dataService.stockDataService;


import utility.poResultMsg.StockPOResultMsg;

public interface StockDataService {
    public StockPOResultMsg searchStockByCode(String code);
    public StockPOResultMsg searchStockByName(String name);
    public StockPOResultMsg searchStockByMarket(String market);
}
