package UI.graphic.compare.compare_volume;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import vo.StockItem;

public class c_volume_Item extends Pane {
    private c_volume_Item me = this;

    private double high, low, open, close, scale;
    private double volume;
    private double formHead_low = 0;
    private double prefH, prefW;
    private Color color = Color.WHITE;

    public c_volume_Item(StockItem vo, double scale, double prefH, double prefW, double formHead_low) {
        if (vo != null) {
            high = vo.getHigh();
            low = vo.getLow();
            open = vo.getOpen();
            close = vo.getClose();
            volume = vo.getVolume();
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
        big.setLayoutY(money_to_layoutY(volume));
        big.setPrefSize(prefW, volume / scale);
        me.getChildren().add(big);
        big.toBack();



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
