package UI.aaManager;

import UI.littleUI.QiPaoUI;
import UI.loginUI.LoginPane;
import UI.mainUI.MainStage;
import UI.navigationUI.NavigationPane;
import UI.welcomeUI.WelcomeMainUI;
import blService.UserBLService.stub.NormalUserBLServiceStub;
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
        try {

//            QiPaoUI.showTip(loginPane, "aa");
            ClientRunner.getInstance().getNormalUserBLService().login(username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        MainStage.getInstance().changePaneWithNavigation(new WelcomeMainUI());
//


    }

    public void callRegister() {

    }

}
