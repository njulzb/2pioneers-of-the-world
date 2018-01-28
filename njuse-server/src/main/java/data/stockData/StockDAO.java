package data.stockData;

import dataService.stockDataService.StockDataService;
import utility.poResultMsg.StockPOResultMsg;

public class StockDAO implements StockDataService {

    private StockDataListByTxt stockDataListByTxt = StockDataListByTxt.getInstance();

    @Override
    public StockPOResultMsg searchStockByCode(String code) {
        return this.stockDataListByTxt.searchStockByCode(code);
    }

    @Override
    public StockPOResultMsg searchStockByName(String name) {
        return null;
    }

    @Override
    public StockPOResultMsg searchStockByMarket(String market) {
        return null;
    }
}
