package UI.graphic.kDay;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import vo.StockItem;

import java.util.Date;

public class Kday_item extends Pane {

    private double width;
    private Kday_item me = this;
    private double scale = 1;//比例尺（1像素 = scale元)
    private double startPrice, endPrice, maxPrice, minPrice;
    private Date thisDate;

    public Kday_item(double width, double scale, double startPrice, double endPrice, double maxPrice, double minPrice,Date thisDate) {
        this.width = width;
        this.scale = scale;
        this.startPrice = startPrice;
        this.endPrice = endPrice;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.thisDate=thisDate;

        make();
    }


    public void make() {
        Color color = Color.WHITE;
        if (startPrice > endPrice) {
            color = Color.GREEN;
        } else if (startPrice <= endPrice) {
            color = Color.RED;
        }

        Pane line = new Pane();
        line.setPrefSize(1, (maxPrice - minPrice) / scale);
        line.setLayoutX(width / 2);
        line.setLayoutY(maxPrice / scale);
        line.toBack();
        line.setBackground(new Background(new BackgroundFill(color, null, null)));
        me.getChildren().add(line);

        Pane big = new Pane();
        big.setPrefSize(width, Math.abs(startPrice - endPrice) / scale);
        big.setLayoutX(0);
        big.setLayoutY(startPrice / scale);
        big.setStyle("-fx-border-color:  #000000");
        big.setBackground(new Background(new BackgroundFill(color, null, null)));
        big.toFront();
        me.getChildren().add(big);
    }

}
