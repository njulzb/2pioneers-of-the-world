package data.stockData;

import dataService.stockDataService.StockDataService;
import utility.poResultMsg.StockPOResultMsg;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StockDAO implements StockDataService {

    private StockDataListByTxt stockDataListByTxt = StockDataListByTxt.getInstance();

    @Override
    public StockPOResultMsg searchStockByCode(String code) {
        return this.stockDataListByTxt.searchStockByCode(code);
    }

    @Override
    public StockPOResultMsg searchStockByName(String name) {
        return this.stockDataListByTxt.searchStockByName(name);
    }

    @Override
    public StockPOResultMsg searchStockByMarket(String market) {
        return this.stockDataListByTxt.searchStockByMarket(market);
    }



    @Override
    public StockPOResultMsg searchStockByCodeAndDate(String code, Date begin, Date end) {
        return this.stockDataListByTxt.searchStockByCodeAndDate(code,begin,end);
    }

    @Override
    public StockPOResultMsg searchStockByNameAndDate(String name, Date begin, Date end) {

        return this.stockDataListByTxt.searchStockByNameAndDate(name,begin,end);
    }


}
