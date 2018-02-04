package UI.graphic.kDay;

import UI.uiHelper.DateHelper;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import vo.StockItem;

public class LeftMessagePane extends Pane {
    private LeftMessagePane me = this;

    public LeftMessagePane() {
//        me.setStyle(" -fx-background-color: transparent;");
//        me.getStyleClass().add("edge-to-edge");
        me.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

    }

    public void clear() {
        me.getChildren().removeAll(me.getChildren());
    }

    public void update(StockItem vo) {
        double lX = 5;
        double stepY = 50;
        int n = 0;
        Color color = Color.GRAY;
        if (vo.getOpen() > vo.getClose()) {
            color = Color.GREEN;
        } else if (vo.getOpen() < vo.getClose()) {
            color = Color.RED;
        }
        Label label_date = new Label("日期 ");
        label_date.setLayoutX(lX);
        label_date.setLayoutY(n * stepY);
        me.getChildren().add(label_date);

        Label label_dateValue = new Label(DateHelper.formatDate(vo.getDate()));
        label_dateValue.setLayoutX(lX);
        label_dateValue.setLayoutY(n * stepY+20);
        label_dateValue.setTextFill(color);
        me.getChildren().add(label_dateValue);

        n++;


        Label label_open = new Label("开盘价格");
        label_open.setLayoutX(lX);
        label_open.setLayoutY(n * stepY);
        me.getChildren().add(label_open);

        Label label_openValue = new Label(vo.getOpen() + "");
        label_openValue.setLayoutX(lX);
        label_openValue.setLayoutY(n * stepY+20);
        label_openValue.setTextFill(color);
        me.getChildren().add(label_openValue);

        n++;


        Label label_close = new Label("收盘价格" );
        label_close.setLayoutX(lX);
        label_close.setLayoutY(n * stepY);
        me.getChildren().add(label_close);



        Label label_closeValue = new Label(vo.getClose() + "");
        label_closeValue.setLayoutX(lX);
        label_closeValue.setLayoutY(n *stepY +20);
        label_closeValue.setTextFill(color);
        me.getChildren().add(label_closeValue);

        n++;








        Label label_high = new Label("最高价格 ");
        label_high.setLayoutX(lX);
        label_high.setLayoutY(n * stepY);
        me.getChildren().add(label_high);


        Label label_highValue = new Label(vo.getHigh() + "");
        label_highValue.setLayoutX(lX);
        label_highValue.setLayoutY(n * stepY+20);
        label_highValue.setTextFill(color);
        me.getChildren().add(label_highValue);
        n++;




        Label label_low = new Label("最低价格 " );
        label_low.setLayoutX(lX);
        label_low.setLayoutY(n * stepY);
        me.getChildren().add(label_low);



        Label label_lowValue = new Label(vo.getLow() + "");
        label_lowValue.setLayoutX(lX);
        label_lowValue.setLayoutY(n * stepY+20);
        label_lowValue.setTextFill(color);
        me.getChildren().add(label_lowValue);
        n++;


        Label label_amount = new Label("成交量" );
        label_amount.setLayoutX(lX);
        label_amount.setLayoutY(n * stepY);
        me.getChildren().add(label_amount);



        Label label_amountValue = new Label(vo.getVolume()+ "");
        label_amountValue.setLayoutX(lX);
        label_amountValue.setLayoutY(n * stepY+20);
        label_amountValue.setTextFill(color);
        me.getChildren().add(label_amountValue);
        n++;
    }

}
