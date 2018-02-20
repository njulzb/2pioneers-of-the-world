package UI.graphic.compare.compare_volume;

import UI.graphic.compare.compare_kday.c_kday_graphic;
import UI.graphic.compare.compare_logRate.c_logRate_graphic;
import UI.graphic.newKDay.LeftMessagePane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import resultMsg.StockResultMsg;
import vo.StockVO;

import java.util.ArrayList;

public class c_volume_mainPane extends Pane {
    private c_volume_mainPane me = this;
    private ArrayList<StockVO> stockList = new ArrayList<StockVO>();
    private c_volume_leftPane leftMessagePane;
    private c_volume_graphic graphicPane;

    public c_volume_mainPane(ArrayList<StockVO> stockList) {
        this.stockList.addAll(stockList);
        me.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        me.setPrefHeight(500);
        make();

    }

    private void make() {
        initGraphicPane();
    }

    private void initLeftPane() {
        leftMessagePane = new c_volume_leftPane();
        leftMessagePane.setLayoutX(0);
        leftMessagePane.setLayoutY(0);
        me.getChildren().add(leftMessagePane);
    }

    private void initGraphicPane() {
        graphicPane = new c_volume_graphic(stockList, leftMessagePane);
        graphicPane.setLayoutX(0);
        graphicPane.setLayoutY(45);
        me.getChildren().add(graphicPane);

    }

}
