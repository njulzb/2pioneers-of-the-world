package UI.graphic.compare.compare_logRate;

import UI.graphic.compare.compare_kday.c_kday_oneStockCard;
import UI.graphic.newKDay.LeftMessagePane;
import UI.graphic.newKDay.kday_item;
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

public class c_logRate_graphic extends Pane {

    private c_logRate_graphic me = this;
    private double prefW = 600, prefH = 400;


    private double high = 0, low = 0, scale = 1;
    private LeftMessagePane leftPane;
    private ArrayList<StockVO> stockList = new ArrayList<StockVO>();
    private ArrayList<c_kday_oneStockCard> cardList = new ArrayList<c_kday_oneStockCard>();

    private static final int formHeadNum = 5; //fromHeadNum：表头刻度的个数


    public c_logRate_graphic(ArrayList<StockVO> stockList, LeftMessagePane leftPane) {
        this.stockList.addAll(stockList);
        System.out.println("在graphicPane的构造函数里，stocklist.size="+this.stockList.size());

        this.leftPane = leftPane;
        make();

    }
    private void make() {
        initBackground();
        initScale();
        initFormHead();
        addAllStock();

    }

    private void initBackground() {
        me.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        me.setPrefSize(prefW, prefH);
    }


    private void initScale() {
        low = 100000000;
        for (StockVO svo : stockList) {
            for (StockItem stockItem : svo.getStockItemArrayList()) {
                if (stockItem.getHigh() > high) {
                    high = stockItem.getHigh();
                }
                if (stockItem.getLow() < low) {
                    low = stockItem.getLow();
                }
            }
        }

        high = Math.ceil(high);
        low = Math.floor(low);
        scale = (high - low) / me.getPrefHeight();
        System.out.println("high=" + high + ",low=" + low + ",scale=" + scale);

    }

    private void initFormHead() {
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


                double money = low + Math.floor(nt * scale * 100) / 100.0;
                Label c_l = new Label(money + "");
                c_l.setLayoutX(prefW - 18);
                c_l.setLayoutY(graphicY_to_layoutY(nt) - 9);
                c_l.setTextFill(Color.WHITE);
                me.getChildren().add(c_l);
            }
        }

    }


    private void addAllStock() {

        for (StockVO vo : stockList) {
            c_kday_oneStockCard card = new c_kday_oneStockCard();
            drawItems(vo.getStockItemArrayList(), card);
            card.showAll();
            card.setAllUnActive();
            cardList.add(card);
        }
        changeCard(0);

    }

   public void changeCard(int index) {
        System.out.println("cardList.size="+cardList.size());
        if (index > cardList.size() - 1) {
            System.out.println("error!changeCard时index超出list大小");
        } else {
            for (int i = 0; i < cardList.size(); i++) {
                if (i == index) {
                    cardList.get(i).setAllActive();
                } else {
                    cardList.get(i).setAllUnActive();
                }
            }
        }

    }

    private void drawItems(ArrayList<StockItem> list, c_kday_oneStockCard StockCard) {
        int n = list.size();
        if (n == 0) {
            System.out.println("error ,item=0");
            return;
        }
        double itemW = (prefW - 30) / n;
        System.out.println("scale=" + scale);
        int i = 0;
        for (StockItem vo : list) {
            kday_item it = new kday_item(vo, scale, prefH, itemW, low);
            StockCard.getList().add(it);
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
