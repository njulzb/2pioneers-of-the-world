package UI.graphic.kDay;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import vo.StockItem;

import java.util.Date;

public class Kday_item extends Pane {

    private double width;
    private double height;
    private Kday_item me = this;
    private double scaleUP = 1;//比例尺（1像素 = scale元)
    private double scaleDown = 1;//比例尺（1像素 = scale手)
    private double startPrice, endPrice, maxPrice, minPrice;
    private double volume = 0;
    private Date thisDate;

    public Kday_item(double width, double height, double scaleUP, double scaleDown, StockItem itemVO) {
        this.width = width;
        this.height = height;
        this.scaleUP = this.scaleUP;
        this.startPrice = itemVO.getOpen();
        this.endPrice = itemVO.getClose();
        this.maxPrice = itemVO.getHigh();
        this.minPrice = itemVO.getLow();
        this.thisDate = itemVO.getDate();
        this.scaleDown = scaleDown;
        this.volume = itemVO.getVolume();

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
        line.setPrefSize(1, (maxPrice - minPrice) / scaleUP);
        line.setLayoutX(width / 2);
        line.setLayoutY(minPrice / scaleUP);
        line.toBack();
        line.setBackground(new Background(new BackgroundFill(color, null, null)));
        me.getChildren().add(line);

        Pane big = new Pane();
        big.setPrefSize(width, Math.abs(startPrice - endPrice) / scaleUP);
        big.setLayoutX(0);
        big.setLayoutY(endPrice / scaleUP);
        big.setStyle("-fx-border-color:  #000000");
        big.setBackground(new Background(new BackgroundFill(color, null, null)));
        big.toFront();
        me.getChildren().add(big);
    }

}
