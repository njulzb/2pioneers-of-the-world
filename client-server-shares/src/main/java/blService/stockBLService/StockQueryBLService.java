package blService.stockBLService;

import utility.keyForSearch.KeyForSearchStock;
import utility.resultMsg.StockResultMsg;


public interface StockQueryBLService {
    public StockResultMsg querySingleByKey(KeyForSearchStock key);
}
