package blService.stockBLService;

import utility.keyForSearch.KeyForSearchStock;
import utility.resultMsg.voResultMsg.StockResultMsg;


public interface StockQueryBLService {
    public StockResultMsg querySingleByKey(KeyForSearchStock key);
}
