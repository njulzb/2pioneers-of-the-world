package UI.loginUI;

import UI.aaManager.LoginManager;
import UI.littleUI.MyButton;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class LoginPane extends Pane {

    public LoginPane me = this;
    public LoginManager manager=new LoginManager(me);
    


    public LoginPane() {
        me.setPrefHeight(220);
        me.setPrefWidth(280);
//        me.setStyle("-fx-border-color:  #545454");
//        me.setBackground(new Background(new BackgroundFill(Color, null, null)));
        makeUI();


    }

    public void makeUI() {


        Label label_username = new Label("账号：");
        label_username.setLayoutX(0);
        label_username.setLayoutY(80);
        me.getChildren().add(label_username);


        TextField unField = new TextField();
        unField.setPrefSize(150, 20);
        unField.setLayoutX(40);
        unField.setLayoutY(80);
        me.getChildren().add(unField);


        Label label_Password = new Label("密码：");
        label_Password.setLayoutX(0);
        label_Password.setLayoutY(110);
        me.getChildren().add(label_Password);


        PasswordField pwField = new PasswordField();
        pwField.setPrefSize(150, 20);
        pwField.setLayoutX(40);
        pwField.setLayoutY(110);
        me.getChildren().add(pwField);


        MyButton button_register =new MyButton( "注册" ,18 ,80);
        button_register.setLayoutX(0);
        button_register.setLayoutY(150);
        me.getChildren().add(button_register);
        button_register.setOnAction((ActionEvent event) -> {
            manager.callRegister();
        });


        MyButton button_login =new MyButton( "登录" ,18 ,80);
        button_login.setLayoutX(107);
        button_login.setLayoutY(150);
        me.getChildren().add(button_login);
        button_login.setOnAction((ActionEvent event) -> {
            manager.login(unField.getText(),pwField.getText());
        });






    }

    public void enter() {
        me.setOpacity(0);
        Task t = new Task() {
            @Override
            protected Object call() throws Exception {
                for (int i = 0; i < 20; i++) {
                    me.setOpacity(i * 0.05);
                    Thread.sleep(50);
                }
                return "";
            }
        };
        new Thread(t).start();
    }


    public void exit() {
        Task t = new Task() {
            @Override
            protected Object call() throws Exception {
                for (int i = 0; i < 20; i++) {
                    me.setLayoutY(me.getLayoutY() - 5 * i);
                    me.setOpacity(1 - i * 0.1);
                    Thread.sleep(50);
                }
                me.setVisible(false);
                return "";
            }
        };
        new Thread(t).start();
    }

}
