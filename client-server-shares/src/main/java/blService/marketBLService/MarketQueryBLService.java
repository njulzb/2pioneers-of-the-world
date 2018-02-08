package blService.marketBLService;

import resultMsg.MarketResultMsg;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface MarketQueryBLService extends Remote{
    MarketResultMsg queryMarketByDate(Date date) throws RemoteException;
}
