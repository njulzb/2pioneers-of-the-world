package bl.stockBL;

import blService.stockBLService.StockQueryBLService;
import data.stockData.StockDataListByTxt;
import keyForSearch.KeyForSearchStock;
import resultMsg.StockResultMsg;
import utility.poResultMsg.StockPOResultMsg;

import java.util.Date;


public class StockBLController implements StockQueryBLService {

    private StockList stockList = new StockList();

    @Override
    public StockResultMsg queryStockByKey(KeyForSearchStock key) {
       return this.stockList.queryStockByKey(key);
    }

    @Override
    public StockResultMsg queryStockByCodeAndDate(String code, Date begin, Date end) {
        return this.stockList.queryStockByCodeAndDate(code,begin,end);
    }
}
