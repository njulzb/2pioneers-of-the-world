package bl.stockBL;

import blService.stockBLService.StockQueryBLService;
import utility.keyForSearch.KeyForSearchStock;
import utility.resultMsg.voResultMsg.StockResultMsg;

public class StockBLController implements StockQueryBLService {
    @Override
    public StockResultMsg querySingleByKey(KeyForSearchStock key) {
        return null;
    }
}
