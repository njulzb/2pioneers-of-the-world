package UI.aaManager;

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
            ClientRunner.getInstance().getNormalUserBLService().login(username,password);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        MainStage.getInstance().changePaneWithNavigation(new WelcomeMainUI());



    }

    public void callRegister() {

    }

}
