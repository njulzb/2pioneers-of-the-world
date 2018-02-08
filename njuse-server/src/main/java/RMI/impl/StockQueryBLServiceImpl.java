package RMI.impl;

import bl.stockBL.StockBLController;
import blService.stockBLService.StockQueryBLService;
import keyForSearch.KeyForSearchStock;
import resultMsg.StockResultMsg;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class StockQueryBLServiceImpl extends UnicastRemoteObject implements StockQueryBLService {
    private StockBLController controller = new StockBLController();

    public StockQueryBLServiceImpl() throws RemoteException {
    }

    @Override
    public StockResultMsg queryStockByKey(KeyForSearchStock key) throws RemoteException {
        return this.controller.queryStockByKey(key);
    }

    @Override
    public StockResultMsg queryStockByCodeAndDate(String code, Date begin, Date end) throws RemoteException {
        return this.controller.queryStockByCodeAndDate(code,begin,end);
    }

    @Override
    public StockResultMsg queryStockByNameAndDate(String name, Date begin, Date end) throws RemoteException {
        return this.controller.queryStockByNameAndDate(name,begin,end);
    }
}
