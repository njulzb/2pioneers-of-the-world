package RMI.impl;

import bl.marketBL.MarketBLController;
import blService.marketBLService.MarketQueryBLService;
import resultMsg.MarketResultMsg;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class MarketQueryBLServiceImpl extends UnicastRemoteObject implements MarketQueryBLService{

    private MarketQueryBLService controller = new MarketBLController();


    public MarketQueryBLServiceImpl() throws RemoteException {
    }

    @Override
    public MarketResultMsg queryMarketByDate(Date date) throws RemoteException {
        return this.controller.queryMarketByDate(date);
    }
}
