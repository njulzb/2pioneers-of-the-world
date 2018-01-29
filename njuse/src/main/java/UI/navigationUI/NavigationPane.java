package UI.navigationUI;

import UI.aaManager.NavigationManager;
import UI.uiHelper.UISys;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class NavigationPane extends Pane {
    private NavigationManager manager = new NavigationManager();
    private NavigationPane me = this;
    private boolean isLeftHiding = false, isRightEntering = false;

    public static final double NavigationWidth = 100;


    public NavigationPane() {
        me.setBackground(new Background(new BackgroundFill(Color.rgb(40, 31, 29), null, null)));
        me.setPrefHeight(UISys.getWindowsH());
        me.setPrefWidth(NavigationWidth);
        ;
        this.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                rightEnter();
            }
        });
        this.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                leftHide();
            }
        });


        me.toFront();
        makeUI();
    }

    private void makeUI() {
        int n = 1, step = 40;
        FunctionItemPane item_1 = new FunctionItemPane("导览");
        item_1.setLayoutY(n * step);
        item_1.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                manager.callGuide();
            }
        });
        me.getChildren().add(item_1);
        n++;

        FunctionItemPane item_2 = new FunctionItemPane("大盘概览");
        item_2.setLayoutY(n * step);
        item_2.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
            }
        });
        me.getChildren().add(item_2);
        n++;

        FunctionItemPane item_3 = new FunctionItemPane("个股查询");
        item_3.setLayoutY(n * step);
        item_3.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                manager.callStockMessage();
            }
        });
        me.getChildren().add(item_3);
        n++;

        FunctionItemPane item_4 = new FunctionItemPane("市场温度计");
        item_4.setLayoutY(n * step);
        item_4.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
            }
        });
        me.getChildren().add(item_4);
        n++;


        Line downLine = new Line();
        downLine.setStartX(0);
        downLine.setLayoutY(n * step);
        downLine.setFill(Color.WHITE);
        downLine.setStyle("-fx-border-color:  #545454");
        downLine.setEndX(NavigationPane.NavigationWidth);
        downLine.setEndY(150);
        n++;
    }

    private void leftHide() {
        if (isRightEntering) {
            isRightEntering = false;
        }
        isLeftHiding = true;
        Task t = new Task() {
            @Override
            protected Object call() throws Exception {


                while (isLeftHiding && me.getLayoutX() > -80) {
                    me.setLayoutX(me.getLayoutX() - 3);
                    Thread.sleep(30);
                }
                isLeftHiding = false;
                return "";
            }
        };
        new Thread(t).start();
    }

    private void rightEnter() {
        if (isLeftHiding) {
            isLeftHiding = false;
        }
        isRightEntering = true;
        Task t = new Task() {
            @Override
            protected Object call() throws Exception {


                while (isRightEntering && me.getLayoutX() < -3) {
                    me.setLayoutX(me.getLayoutX() + 3);
                    Thread.sleep(10);
                }
                isRightEntering = false;
                return "";
            }
        };
        new Thread(t).start();
    }

}
