package UI.graphic.newKDay;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import vo.StockItem;

public class kday_item extends Pane {
    private kday_item me = this;

    private double high, low, open, close, scale;
    private double formHead_low = 0;
    private double prefH, prefW;
    private Color color = Color.WHITE;

    public kday_item(StockItem vo, double scale, double prefH, double prefW, double formHead_low) {
        if (vo != null) {
            high = vo.getHigh();
            low = vo.getLow();
            open = vo.getOpen();
            close = vo.getClose();

        }




        this.formHead_low = formHead_low;
        this.scale = scale;
        this.prefH = prefH;
        this.prefW = prefW;
        me.setPrefSize(prefW, prefH);
        make();
    }

    private void make() {
        if (open > close) {
            color = Color.GREEN;
        } else if (open < close) {
            color = Color.RED;
        }


        Pane big = new Pane();
        big.setBackground(new Background(new BackgroundFill(color, null, null)));
        big.setLayoutY(money_to_layoutY(Math.max(open, close)));
        big.setPrefSize(prefW, Math.abs(open - close) / scale);
        me.getChildren().add(big);
        big.toBack();

        Line line = new Line(prefW / 2, money_to_layoutY(low), prefW / 2, money_to_layoutY(high));
        line.setStroke(color);
        line.setStrokeWidth(1);
        me.getChildren().add(line);

    }

    private double graphicX_to_layoutX(double graphicX) {
        return graphicX;
    }

    private double graphicY_to_layoutY(double graphicY) {
        return me.getPrefHeight() - graphicY;
    }

    private double money_to_layoutY(double money) {
        return graphicY_to_layoutY((money - formHead_low) / scale);
    }
}
