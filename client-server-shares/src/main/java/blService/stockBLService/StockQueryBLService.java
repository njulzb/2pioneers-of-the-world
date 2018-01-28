package blService.stockBLService;

import keyForSearch.KeyForSearchStock;
import resultMsg.StockResultMsg;


public interface StockQueryBLService {
    public StockResultMsg queryStockByKey(KeyForSearchStock key);
}
