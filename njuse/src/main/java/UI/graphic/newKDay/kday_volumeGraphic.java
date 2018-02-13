package UI.graphic.newKDay;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import vo.StockItem;
import vo.StockVO;

import java.util.ArrayList;

public class kday_volumeGraphic extends Pane {


    public kday_volumeGraphic me = this;


    private static double prefW = 600, prefH = 120;
    private ArrayList<StockItem> list = new ArrayList<StockItem>();
    private double high = 0, low = 0, scale = 1;

    private LeftMessagePane leftPane;

    private static final int formHeadNum = 5; //fromHeadNum：表头刻度的个数


    public kday_volumeGraphic(StockVO vo, LeftMessagePane leftPane) {
        if (vo != null) {
            list.addAll(vo.getStockItemArrayList());
        } else {
            System.out.println("error !  绘制kDayMainPane时，传入的vo为null");
            return;
        }
        me.setPrefSize(prefW, prefH);
        this.leftPane = leftPane;

        make();
    }

    public void make() {
        initBackground();
        initScale();
        drawFormHead();
        drawItems();
    }

    private void initBackground() {
        me.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                System.out.println("当前点击位置y=" + e.getY() + ",(h-y)*scale=" + (prefH - e.getY()) * scale);


            }
        });


        me.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        me.setPrefSize(prefW, prefH);
    }

    private void initScale() {
        low = 0;
        for (StockItem ivo : list) {

            if (high < ivo.getVolume()) {
                high = ivo.getVolume();
            }

            if (low > ivo.getVolume()) {
                low = ivo.getVolume();
            }
        }
//        high = high * 1.1;
        high = Math.ceil(high);
//        low = low * 0.9;
        low = Math.floor(low);
        scale = (high - low) / me.getPrefHeight();
//        System.out.println("high=" + high + ",low=" + low + ",scale=" + scale);
    }

    private void drawFormHead() {
        Line line_down = new Line(0, graphicY_to_layoutY(0), me.getPrefWidth() - 30, graphicY_to_layoutY(0));
        line_down.setStroke(Color.WHITE);
        line_down.setStrokeWidth(1);
        me.getChildren().add(line_down);

        Line line_right = new Line(me.getPrefWidth() - 30, graphicY_to_layoutY(0), me.getPrefWidth() - 30, 0);
        line_right.setStroke(Color.WHITE);
        line_right.setStrokeWidth(1);
        me.getChildren().add(line_right);


        double stepLayout = prefH / formHeadNum;
        for (int i = 0; i < formHeadNum; i++) {
            int nt = (int) (Math.floor(i * stepLayout));
            if (graphicY_to_layoutY(nt) > 0) {
                Line c = new Line(prefW - 30, graphicY_to_layoutY(nt), prefW - 20, graphicY_to_layoutY(nt));
                c.setStroke(Color.WHITE);
                c.setStrokeWidth(1);
                me.getChildren().add(c);


                Line c1 = new Line(0, graphicY_to_layoutY(nt), prefW - 30, graphicY_to_layoutY(nt));
                c1.setStroke(Color.DARKGRAY);
                c1.setStrokeWidth(0.1);
                me.getChildren().add(c1);


                int money =  ((int)Math.floor(nt * scale / 10000000)) * 1000;
                Label c_l = new Label(money + " 万");
                c_l.setLayoutX(prefW - 18);
                c_l.setLayoutY(graphicY_to_layoutY(nt) - 9);
                c_l.setTextFill(Color.WHITE);
                me.getChildren().add(c_l);
            }
        }


    }

    private void drawItems() {
        int n = list.size();
        if (n == 0) {
            System.out.println("error ,item=0");
            return;
        }

        double itemW = (prefW - 30) / n;
        System.out.println("scale=" + scale);
        int i = 0;
        for (StockItem vo : list) {
            kday_volumeItem it = new kday_volumeItem(vo, scale, prefH, itemW, low);
            it.setOnMouseEntered(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent e) {
                    leftPane.update(vo);
                }
            });
            it.setOnMouseExited(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent e) {
                    leftPane.clear();
                }
            });

            it.setLayoutX(i * itemW);
            me.getChildren().add(it);
            i++;
        }

    }


    private double graphicX_to_layoutX(double graphicX) {
        return graphicX;
    }

    private double graphicY_to_layoutY(double graphicY) {
        return me.getPrefHeight() - graphicY;
    }

    private double money_to_layoutY(double money) {
        return graphicY_to_layoutY((money - low) / scale);
    }


}
