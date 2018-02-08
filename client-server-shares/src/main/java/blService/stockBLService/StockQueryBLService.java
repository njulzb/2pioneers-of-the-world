package blService.stockBLService;

import keyForSearch.KeyForSearchStock;
import resultMsg.StockResultMsg;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;


public interface StockQueryBLService extends Remote{
    StockResultMsg queryStockByKey(KeyForSearchStock key) throws RemoteException;
    StockResultMsg queryStockByCodeAndDate(String code,Date begin ,Date end) throws RemoteException;
    StockResultMsg queryStockByNameAndDate(String name,Date begin,Date end) throws RemoteException;

}
