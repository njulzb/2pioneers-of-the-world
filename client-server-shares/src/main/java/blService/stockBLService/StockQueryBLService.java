package blService.stockBLService;

import keyForSearch.KeyForSearchStock;
import resultMsg.StockResultMsg;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;


public interface StockQueryBLService extends Remote{
    public StockResultMsg queryStockByKey(KeyForSearchStock key) throws RemoteException;
    public StockResultMsg queryStockByCodeAndDate(String code,Date begin ,Date end) throws RemoteException;
    public StockResultMsg queryStockByNameAndDate(String name,Date begin,Date end) throws RemoteException;
}
