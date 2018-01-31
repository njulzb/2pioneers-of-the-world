package UI.loginUI;

import UI.uiHelper.ImageHelper;
import UI.uiHelper.UISys;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginMainUI extends Application {
    public Pane root = new Pane();
    private Stage thisStage;


    public LoginMainUI() {

        makeUI();

    }


    public static void main(String[] args) {
        Application.launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        root.setStyle("-fx-border-color:  #545454");
        Scene scene = new Scene(root, UISys.getWindowsW(), UISys.getWindowsH());
        this.thisStage = primaryStage;
        primaryStage.initStyle(StageStyle.TRANSPARENT);// 无边框
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setScene(scene);

        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public void makeUI() {
        Label label_backgroundImg = new Label("", new ImageView(ImageHelper.getImg("login\\loginBackImg.jpg")));
        root.getChildren().add(label_backgroundImg);

        Pane loginBackPane = new Pane();
        loginBackPane.setPrefSize(220, UISys.getWindowsH());
        loginBackPane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        loginBackPane.setOpacity(0.6);
        loginBackPane.toBack();
        root.getChildren().add(loginBackPane);

        LoginPane lPane = new LoginPane();
        lPane.setLayoutY(120);
        lPane.setLayoutX(20);
        root.getChildren().add(lPane);

    }
}