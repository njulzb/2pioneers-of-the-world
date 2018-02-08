package RMI.impl;

import bl.userBL.UserBLController;
import blService.UserBLService.NormalUserBLService;
import resultMsg.UserResultMsg;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class NormalUserBLServiceImpl extends UnicastRemoteObject implements NormalUserBLService {


    public NormalUserBLServiceImpl() throws RemoteException {
    }

    @Override
    public UserResultMsg login(String account, String password) throws RemoteException {
        return new UserBLController().login(account,password);
    }
}
