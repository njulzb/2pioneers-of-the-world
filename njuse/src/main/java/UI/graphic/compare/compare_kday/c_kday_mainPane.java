package UI.graphic.compare.compare_kday;

import UI.graphic.newKDay.LeftMessagePane;
import UI.littleUI.MyButton;
import javafx.event.ActionEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import vo.StockVO;

import java.util.ArrayList;

public class c_kday_mainPane extends Pane {
    private c_kday_mainPane me = this;
    private ArrayList<StockVO> stockList = new ArrayList<StockVO>();
    private LeftMessagePane leftMessagePane;
    private c_kday_graphic graphicPane;

    public c_kday_mainPane(ArrayList<StockVO> stockList) {
        this.stockList.addAll(stockList);
        me.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
me.setPrefHeight(500);
        make();

    }

    private void make() {
        initLeftPane();
        initGraphicPane();
        initCardChangeButton();
    }

    private void initLeftPane() {
        leftMessagePane = new LeftMessagePane();
        leftMessagePane.setLayoutX(0);
        leftMessagePane.setLayoutY(0);
        me.getChildren().add(leftMessagePane);
    }

    private void initGraphicPane() {
        System.out.println("在mainpane构造graphicPane的时候，stocklist.size="+stockList.size());
        graphicPane = new c_kday_graphic(stockList, leftMessagePane);
        graphicPane.setLayoutX(100);
        graphicPane.setLayoutY(45);
        me.getChildren().add(graphicPane);

    }

    private void initCardChangeButton() {
        double startLayoutX = 120;
        double stepX = 100;
        double layoutY = 10;
        for (int i = 0; i < stockList.size(); i++) {
            MyButton button = new MyButton(stockList.get(i).getName(), 30, 80);
              final int index=i;
            button.setOnAction((ActionEvent event) -> {
                graphicPane.changeCard(index);
            });
            button.setLayoutX(startLayoutX + i * stepX);
            button.setLayoutY(layoutY);
            me.getChildren().add(button);
        }
    }


}
