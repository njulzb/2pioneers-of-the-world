package RMI;

import RMI.impl.NormalUserBLServiceImpl;
import RMI.impl.StockQueryBLServiceImpl;
import blService.UserBLService.NormalUserBLService;
import blService.stockBLService.StockQueryBLService;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServerRunner {

    final static String IP = "127.0.0.1";
    final static int PORT = 8008;
    String name ;
    public ServerRunner() {
        this.name = "rmi://ip:port/service";
        this.name = this.name.replaceAll("ip",IP);
        this.name = this.name.replaceAll("port",Integer.toString(PORT));
    }

    public void start(){




        try {
            LocateRegistry.createRegistry(PORT);

            //user
            NormalUserBLService normalUserBLService = new NormalUserBLServiceImpl();
            Naming.rebind(this.name.replaceAll("service","NormalUserBLService") , normalUserBLService);
//            stock query bl service
            StockQueryBLService stockQueryBLService = new StockQueryBLServiceImpl();
            Naming.rebind(this.name.replaceAll("service","StockQueryBLService"),stockQueryBLService);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        System.out.println("server launched successfully");

    }

    public static void main(String[] args){
        ServerRunner runner = new ServerRunner();
        runner.start();
    }
}
