package blService.stockBLService.stub;

import blService.stockBLService.StockQueryBLService;
import keyForSearch.KeyForSearchStock;
import resultMsg.StockResultMsg;
import vo.StockItem;
import vo.StockVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public class StockQueryBLServiceStub implements StockQueryBLService {
    @Override
    public StockResultMsg queryStockByKey(KeyForSearchStock key) {
        StockItem item = new StockItem(new Date(),1,2,3,4,5,6);
        ArrayList<StockItem> stockItemArrayList = new ArrayList<StockItem>();
        stockItemArrayList.add(item);
        StockVO stockVO = new StockVO("1","stub stock","stub market",stockItemArrayList);

        StockResultMsg resultMsg = new StockResultMsg(true,"success",stockVO);
        return resultMsg;
    }

    @Override
    public StockResultMsg queryStockByCodeAndDate(String code, Date begin, Date end) {
        StockItem item = new StockItem(new Date(),1,2,3,4,5,6);
        ArrayList<StockItem> stockItemArrayList = new ArrayList<StockItem>();
        stockItemArrayList.add(item);
        StockVO stockVO = new StockVO("1","stub stock","stub market",stockItemArrayList);
        StockResultMsg resultMsg = new StockResultMsg(true,"success",stockVO);
        return resultMsg;
    }

    @Override
    public StockResultMsg queryStockByNameAndDate(String name, Date begin, Date end) throws RemoteException {
        StockItem item = new StockItem(new Date(),1,2,3,4,5,6);
        ArrayList<StockItem> stockItemArrayList = new ArrayList<StockItem>();
        stockItemArrayList.add(item);
        StockVO stockVO = new StockVO("1","stub stock","stub market",stockItemArrayList);
        StockResultMsg resultMsg = new StockResultMsg(true,"success",stockVO);
        return resultMsg;
    }
}
