package bl.UserBL;

import blService.UserBLService.NormalUserBLService;
import org.junit.jupiter.api.Test;

import resultMsg.UserResultMsg;
import vo.UserVO;

import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

class UserBLControllerTest {
    @Test
    void login() throws RemoteException {
        NormalUserBLService normalUserBLService = new UserBLController();
        String account = "161250063" ,name = "lzb", password = "161250063";
        UserResultMsg resultMsg = normalUserBLService.login( account,password);
        UserResultMsg answer = new UserResultMsg(true,"successful",new UserVO(account,name,password));
        assertEquals(answer,resultMsg);
    }

}