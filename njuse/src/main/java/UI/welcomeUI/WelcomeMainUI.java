package UI.welcomeUI;

import UI.aaManager.WelcomeManager;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class WelcomeMainUI extends Pane {
    private WelcomeMainUI me = this;
    private WelcomeManager manage = new WelcomeManager(me);

    public WelcomeMainUI() {
        me.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        me.setPrefSize(800, 600);
        make();
    }

    public void make() {
        Timestamp nowTime = new Timestamp(System.currentTimeMillis());

        Label label_nowTime = new Label("欢迎，当前时间： " + nowTime.toString());
        label_nowTime.setLayoutX(50);
        label_nowTime.setLayoutY(18);
        label_nowTime.setTextFill(Color.WHITE);
        me.getChildren().add(label_nowTime);

        Pane line = new Pane();
        line.setLayoutX(40);
        line.setLayoutY(40);
        line.setPrefSize(720, 2);
        line.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, null, null)));
        me.getChildren().add(line);


        FunctionSqua func1 = new FunctionSqua("市场概览", "function\\marketView.png");
        func1.setLayoutX(100);
        func1.setLayoutY(200);
        me.getChildren().add(func1);

        FunctionSqua func2 = new FunctionSqua("股票详情", "function\\stockMessage.png");
        func2.setLayoutX(300);
        func2.setLayoutY(200);
        func2.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                manage.callFunction_stockMessage();
            }
        });
        me.getChildren().add(func2);

        FunctionSqua func3 = new FunctionSqua("市场温度计", "function\\marketTem.png");
        func3.setLayoutX(500);
        func3.setLayoutY(200);
        func3 .setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                manage.callFunction_marketThermometer();
            }
        });
        me.getChildren().add(func3);
    }


}
