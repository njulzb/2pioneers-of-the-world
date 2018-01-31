package UI.graphic.kDay;

import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import vo.StockItem;
import vo.StockVO;

import java.util.ArrayList;
import java.util.Date;

public class Kday_graphicPane extends Pane {


    private Kday_graphicPane me = this;
    private Date startDate, endDate;
    private StockVO vo;
    private String stockName = "茅台集团";
    private String stockCode = "FUEU0903";
    private ScrollPane sp;
    private LeftMessagePane leftMessagePane = new LeftMessagePane();

    private ArrayList<StockItem> list = new ArrayList<StockItem>();


    public static double prefH = 400;
    private static double prefW = 600;
    private static double prefWmax = 600;

    public Kday_graphicPane(StockVO vo) {
        this.vo = vo;
//       me.setStyle("-fx-border-color:  #ffffff");
        initData();
        me.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        me.setPrefSize(prefW, prefH);
        make();
    }

    public void initData() {

        if(vo==null){
            initTestData();
        }
        else{

        }


        if (list.size() <= 12) {
            prefW = 50 * list.size();
        }
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
        double scale = max / prefH;

        leftMessagePane.setLayoutX(0);
        leftMessagePane.toFront();
        me.getChildren().add(leftMessagePane);


        FormHead fHead = new FormHead(scale);
        fHead.setLayoutX(prefWmax + 52);
        fHead.setLayoutY(0);
        me.getChildren().add(fHead);

        sp = new ScrollPane();
        sp.getStyleClass().add("edge-to-edge");
        sp.setStyle(" -fx-background-color: transparent;");
        sp.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        sp.setLayoutX(50);
        sp.setLayoutY(0);
        sp.setMinWidth(prefW);
        sp.setMaxWidth(prefW);
        sp.setMinHeight(prefH);
        sp.setMaxHeight(prefH);

        HBox vb = new HBox();
        vb.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        sp.setVmax(prefH);
        sp.setPrefSize(prefW, prefH);
        sp.setContent(vb);
        me.getChildren().add(sp);

        Pane line_buttom = new Pane();
        line_buttom.setLayoutX(50);
        line_buttom.setLayoutY(prefH);
        line_buttom.setPrefSize(600, 1);
        line_buttom.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        me.getChildren().add(line_buttom);


        for (StockItem it : list) {
            Kday_item tp = new Kday_item(width, prefH, scale, it);
            tp.setOnMouseEntered(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent e) {
                    leftMessagePane.update(it);
                }
            });
            tp.setOnMouseExited(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent e) {
                    leftMessagePane.clear();
                }
            });
            tp.setPrefHeight(prefH);
            vb.getChildren().add(tp);

        }


    }

    public void updateLeftMessagePane() {

    }

    public void showLinesFormHead() {

    }


}
