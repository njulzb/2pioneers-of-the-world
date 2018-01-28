package blService.UserBLService;

import org.junit.jupiter.api.Test;
import rmi.ClientRunner;
import utility.resultMsg.UserResultMsg;
import vo.UserVO;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

class NormalUserBLServiceTest {
    @Test
    void login() throws RemoteException, NotBoundException, MalformedURLException {
        NormalUserBLService normalUserBLService = ClientRunner.getInstance().getNormalUserBLService();
        String account = "161250063" , name = "lzb" , password = "161250063";

        UserResultMsg resultMsg = normalUserBLService.login(account,password);
        UserResultMsg answer = new UserResultMsg(true,"successful",new UserVO(account,name,password));
        assertEquals(answer,resultMsg);
    }

}