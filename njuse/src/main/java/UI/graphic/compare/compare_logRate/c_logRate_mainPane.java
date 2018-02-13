package UI.graphic.compare.compare_logRate;

import UI.graphic.compare.compare_kday.c_kday_graphic;
import UI.graphic.compare.compare_kday.c_kday_mainPane;
import UI.graphic.newKDay.LeftMessagePane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import resultMsg.StockResultMsg;
import vo.StockVO;

import java.util.ArrayList;

public class c_logRate_mainPane extends Pane {
    private c_logRate_mainPane me = this;
    private ArrayList<StockResultMsg> stockList = new ArrayList<StockResultMsg>();
    private LeftMessagePane leftMessagePane;
    private c_kday_graphic graphicPane;

    public c_logRate_mainPane(ArrayList<StockResultMsg> stockList) {
        this.stockList.addAll(stockList);
        me.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        me.setPrefHeight(500);
        make();

    }

    private void make() {

    }

    private void initLeftPane() {
        leftMessagePane = new LeftMessagePane();
        leftMessagePane.setLayoutX(0);
        leftMessagePane.setLayoutY(0);
        me.getChildren().add(leftMessagePane);
    }

    private void initGraphicPane() {
//         graphicPane = new c_logRate_graphic(stockList, leftMessagePane);
//        graphicPane.setLayoutX(100);
//        graphicPane.setLayoutY(45);
//        me.getChildren().add(graphicPane);

    }

}
