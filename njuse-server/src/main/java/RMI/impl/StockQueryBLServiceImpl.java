package RMI.impl;

import bl.stockBL.StockBLController;
import blService.stockBLService.StockQueryBLService;
import keyForSearch.KeyForSearchStock;
import resultMsg.StockResultMsg;

import java.util.Date;

public class StockQueryBLServiceImpl implements StockQueryBLService {
    private StockBLController controller = new StockBLController();
    @Override
    public StockResultMsg queryStockByKey(KeyForSearchStock key) {
        return this.controller.queryStockByKey(key);
    }

    @Override
    public StockResultMsg queryStockByCodeAndDate(String code, Date begin, Date end) {
        return this.controller.queryStockByCodeAndDate(code,begin,end);
    }
}
