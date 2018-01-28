package blService.UserBLService;

import resultMsg.UserResultMsg;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NormalUserBLService extends Remote{
    public UserResultMsg login(String account, String password) throws RemoteException;
}