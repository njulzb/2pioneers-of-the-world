package blService.stockBLService.stub;

import blService.stockBLService.StockQueryBLService;
import utility.keyForSearch.KeyForSearchStock;
import utility.resultMsg.voResultMsg.StockResultMsg;
import vo.StockItem;
import vo.StockVO;

import java.util.ArrayList;
import java.util.Date;

public class StockQueryBLServiceStub implements StockQueryBLService {
    @Override
    public StockResultMsg querySingleByKey(KeyForSearchStock key) {
        StockItem item = new StockItem(new Date(),1,2,3,4,5,6);
        ArrayList<StockItem> stockItemArrayList = new ArrayList<StockItem>();
        stockItemArrayList.add(item);
        StockVO stockVO = new StockVO("1","stub stock","stub market",stockItemArrayList);
        ArrayList<StockVO> stockVOArrayList = new ArrayList<StockVO>();
        stockVOArrayList.add(stockVO);
        StockResultMsg resultMsg = new StockResultMsg(true,"success",stockVOArrayList);
        return resultMsg;
    }
}
