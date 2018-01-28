package rmi;


import blService.UserBLService.NormalUserBLService;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

class ClientRunnerTest {
    @org.junit.jupiter.api.Test
    void getNormalUserBLService() throws RemoteException, NotBoundException, MalformedURLException {
        NormalUserBLService normalUserBLService = ClientRunner.getInstance().getNormalUserBLService();
        assert(normalUserBLService!=null );
    }

}