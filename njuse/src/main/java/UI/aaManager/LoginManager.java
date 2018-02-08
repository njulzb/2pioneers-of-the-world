package UI.aaManager;

import UI.littleUI.QiPaoUI;
import UI.littleUI.TipUI;
import UI.loginUI.LoginPane;
import UI.mainUI.MainStage;
import UI.navigationUI.NavigationPane;
import UI.uiHelper.LoginRemember;
import UI.welcomeUI.WelcomeMainUI;
import blService.UserBLService.stub.NormalUserBLServiceStub;
import resultMsg.UserResultMsg;
import rmi.ClientRunner;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class LoginManager {

    private LoginPane loginPane;

    public LoginManager(LoginPane loginPane) {
        this.loginPane = loginPane;
    }


    public void login(String username, String password) {
        UserResultMsg uR = null;
        try {
            uR = ClientRunner.getInstance().getNormalUserBLService().login(username, password);

        } catch (Exception e) {
            QiPaoUI.showTip("网络错误，请重试");
        }
        if (uR.isSuccessful()) {
            LoginRemember.remeberThisTime(username,password);
            MainStage.getInstance().changePaneWithNavigation(new WelcomeMainUI());
        } else {
            QiPaoUI.showTip(uR.getErrorMsg());
           System.out.println(uR.getErrorMsg());
        }


//


    }

    public void callRegister() {

    }

}
