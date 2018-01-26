package UI.loginUI;

import UI.uiHelper.UISys;
import javafx.application.Application;
import javafx.stage.Stage;

public class LoginMainUI extends Application{

    public static void main(String[] args) {
        Application.launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(UISys.getWindowsW());
        primaryStage.setHeight(UISys.getWindowsH());
        primaryStage.setResizable(false);
        primaryStage.show();

    }

}