package rmi;

import blService.UserBLService.NormalUserBLService;
import blService.stockBLService.StockQueryBLService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * use method : ClientRunner.getInstance().getNormalUserBLService();
 */
public class ClientRunner {

    final static String IP = "127.0.0.1";
    final static int PORT = 8008;
    String name = "rmi://" + IP + ":" + PORT + "/service";

    private static ClientRunner instance = new ClientRunner();

    public static ClientRunner getInstance() {
        return instance;
    }

    //services
    NormalUserBLService normalUserBLService;
    StockQueryBLService stockQueryBLService;

    private ClientRunner() {

    }

    public NormalUserBLService getNormalUserBLService() throws RemoteException, NotBoundException, MalformedURLException {
        this.normalUserBLService = (NormalUserBLService)
                Naming.lookup(this.name.replaceAll("service","NormalUserBLService"));

        return this.normalUserBLService;
    }

    public StockQueryBLService getStockQueryBLService() throws RemoteException, NotBoundException, MalformedURLException {
        this.stockQueryBLService = (StockQueryBLService)
                Naming.lookup(this.name.replaceAll("service","StockQueryBLService"));
        return this.stockQueryBLService;
    }
}
