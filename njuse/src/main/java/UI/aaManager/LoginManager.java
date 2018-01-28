package UI.aaManager;

import UI.loginUI.LoginPane;
import UI.mainUI.MainStage;
import UI.navigationUI.NavigationPane;

public class LoginManager {
//    private NormalUserBLServiceStub controller = new NormalUserBLServiceStub();
    private LoginPane loginPane;

    public LoginManager(LoginPane loginPane) {
        this.loginPane = loginPane;
    }


    public void login(String username, String password) {
//        controller.login(username,password);

        MainStage.getInstance().changePane( new NavigationPane());


    }

    public void callRegister() {

    }

}
