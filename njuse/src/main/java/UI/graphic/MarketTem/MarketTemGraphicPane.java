package UI.graphic.MarketTem;


import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MarketTemGraphicPane extends Pane {
    private MarketTemGraphicPane me = this;
    private int[] num = new int[6];
    private int sum = 0;
    private Pane circlePane = new Pane();
    private Pane scalePane = new Pane();

    /**
     * num[0-5] 涨停数，跌停数，涨幅超过5,跌幅超过5，波动幅度大于5%，波动幅度小于5%
     */

    public MarketTemGraphicPane(int[] num) {
        if (num != null) {
            for (int d : num) {
                sum += d;
            }
        } else {
            initTestDate();
        }
        make();


    }

    public void make() {
        me.setPrefSize(150, 150);
        initCirclePane();

    }

    public void initCirclePane() {
        double width = me.getPrefWidth();
        double height = me.getPrefHeight();


        PieChart.Data data_upStop = new PieChart.Data("涨停数", num[0]);


        PieChart.Data data_downStop = new PieChart.Data("跌停数", num[1]);
        PieChart.Data data_up5 = new PieChart.Data("涨幅达到5%", num[2]);
        PieChart.Data data_down5 = new PieChart.Data("跌幅达到5%", num[3]);
        PieChart.Data data_changeOver5 = new PieChart.Data("波动幅度大于5%", num[4]);
        PieChart.Data data_changeLess5 = new PieChart.Data("波动幅度小于5%", num[5]);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        data_upStop,
                        data_up5,
                        data_changeOver5,
                        data_downStop,

                        data_down5,

                        data_changeLess5

                );


        PieChart chart = new PieChart(pieChartData);
        chart.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        chart.setLabelLineLength(30);
        chart.setLegendVisible(false);
        chart.setLegendSide(Side.RIGHT);
        me.getChildren().add(chart);

        for (PieChart.Data data : pieChartData) {
            data.getNode().setOnMouseEntered(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent e) {
                    data.getNode().setScaleX(1.1);
                    data.getNode().setScaleY(1.1);

                }
            });
            data.getNode().setOnMouseExited(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent e) {
                    data.getNode().setScaleX(1);
                    data.getNode().setScaleY(1);

                }
            });
        }
        data_upStop.getNode().setStyle("  -fx-background-color:#FF0000");
        data_downStop.getNode().setStyle("  -fx-background-color:#008000");
        data_up5.getNode().setStyle("  -fx-background-color:#DC143C");
        data_down5.getNode().setStyle("  -fx-background-color:#00FF7F");
        data_changeOver5.getNode().setStyle("  -fx-background-color:#F4A460");
        data_changeLess5.getNode().setStyle("  -fx-background-color:#696969");
    }

    public void initTestDate() {
        num[0] = 30;
        num[1] = 44;
        num[2] = 188;
        num[3] = 172;
        num[4] = 421;
        num[5] = 1800;
        for (int d : num) {
            sum += d;
        }
    }
}
