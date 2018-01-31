package UI.graphic.kDay;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import vo.StockItem;

import java.util.ArrayList;
import java.util.Date;

public class Kday_graphicPane extends Pane {


    private Kday_graphicPane me = this;
    private Date startDate, endDate;
    private String stockName = "茅台集团";
    private String stockCode = "FUEU0903";
    private ArrayList<StockItem> list = new ArrayList<StockItem>();
    private static double prefH = 400;
    private static double prefW = 600;

    public Kday_graphicPane() {

        initData();
        me.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        me.setPrefSize(prefW, prefH);
        make();
    }

    public void initData() {
        initTestData();
    }

    public void initTestData() {
        startDate = new Date(2013, 1, 1);
        endDate = new Date(2013, 1, 5);
        StockItem tp;

        tp = new StockItem(new Date(2013, 1, 1), 100, 200, 3, 130, 20, 100);
        list.add(tp);
        tp = new StockItem(new Date(2013, 1, 2), 130, 150, 80, 140, 20, 100);
        list.add(tp);
        tp = new StockItem(new Date(2013, 1, 3), 130, 150, 80, 140, 20, 100);
        list.add(tp);
        tp = new StockItem(new Date(2013, 1, 4), 130, 150, 80, 140, 20, 100);
        list.add(tp);
        tp = new StockItem(new Date(2013, 1, 5), 190, 150, 80, 140, 20, 100);
        list.add(tp);
    }

    public void make() {
        int n = list.size();
        double width = prefW / n;
        if (width >= 50) {
            width = 50;
        } else if (width <= 5) {
            width = 5;
        }
        double max = 1;
        for (StockItem it : list) {
            if (max < it.getHigh()) {
                max = it.getHigh();
            }
        }
        double scale =  max/prefH;


        ScrollPane sp = new ScrollPane();
        sp.getStyleClass().add("edge-to-edge");
        sp.setStyle(" -fx-background-color: transparent;");
        sp.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        sp.setLayoutX(0);
        sp.setMinWidth(540);
        sp.setMaxWidth(540);
        sp.setMinHeight(300);
        sp.setMaxHeight(300);
        sp.setLayoutY(0);
        HBox vb = new HBox();
        vb.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        sp.setVmax(prefH);
        sp.setPrefSize(prefW, prefH);
        sp.setContent(vb);
        me.getChildren().add(sp);


        for (StockItem it : list) {
            Kday_item tp = new Kday_item(width, scale, it.getOpen(), it.getClose(), it.getHigh(), it.getLow(), it.getDate());
            tp.setPrefHeight(prefH);
            vb.getChildren().add(tp);

        }


    }


}
