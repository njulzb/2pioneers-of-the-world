package UI.mainUI;

import UI.littleUI.MyButton;
import UI.littleUI.MyButton_img;
import UI.loginUI.LoginMainUI;
import UI.navigationUI.NavigationPane;
import UI.uiHelper.ImageHelper;
import UI.uiHelper.UISys;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;

public class MainStage extends Application {
    public Pane root = new Pane();

    private Stage thisStage;
    private ArrayList<Pane> otherPane = new ArrayList<Pane>();

    private static MainStage me = new MainStage();

    public static MainStage getInstance() {
        return me;
    }

    public Stage getThisStage() {
        return thisStage;
    }

    public MainStage() {

    }

    public Pane getRoot() {
        return root;
    }

    public static void main(String[] args) {
        Application.launch(args);


    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        me = this;
        root.setStyle("-fx-border-color:  #545454");
        Scene scene = new Scene(root, UISys.getWindowsW(), UISys.getWindowsH());
        this.thisStage = primaryStage;
        primaryStage.initStyle(StageStyle.TRANSPARENT);// 无边框
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setScene(scene);

        primaryStage.setResizable(false);
        primaryStage.show();
        makeUI();
        changePane(new LoginMainUI().root);

    }

    public void makeUI() {

        MyButton_img label_close = new MyButton_img("littleIcon\\close.png");
        label_close.setLayoutX(750);
        label_close.setLayoutY(10);
        root.getChildren().add(label_close);
        label_close.toFront();
    }


    public void changePane(Pane newPane) {
        if (otherPane.size() != 0) {
            root.getChildren().removeAll(otherPane);
        }

        root.getChildren().add(newPane);
        otherPane.add(newPane);

    }

    public void changePaneWithNavigation(Pane newPane) {
        if (otherPane.size() != 0) {
            root.getChildren().removeAll(otherPane);
        }
        NavigationPane naPane = new NavigationPane();
        naPane.setLayoutX(-80);

        otherPane.add(newPane);
        otherPane.add(naPane);
        root.getChildren().add(newPane);
        root.getChildren().add(naPane);
    }
}