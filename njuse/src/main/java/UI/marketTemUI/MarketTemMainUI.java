package UI.marketTemUI;

import UI.graphic.MarketTem.MarketTemGraphicPane;
import UI.stockUI.StockMessageUI;
import UI.uiHelper.DateHelper;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import vo.MarketVO;
import vo.StockVO;


import java.util.Date;

public class MarketTemMainUI extends Pane {
    private MarketTemMainUI me = this;
    private MarketVO vo;

    public MarketTemMainUI(MarketVO vo) {

        if (vo != null) {
            this.vo = vo;
        } else {
            initTestDate();
        }
        me.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        me.setPrefSize(800, 600);
        make();
    }

    public void make() {
        Label label_title = new Label("市場溫度計");
        label_title.setLayoutX(50);
        label_title.setLayoutY(20);
        label_title.setTextFill(Color.WHITE);
        this.getChildren().add(label_title);

        Pane line = new Pane();
        line.setLayoutX(40);
        line.setLayoutY(40);
        line.setPrefSize(720, 2);
        line.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, null, null)));
        me.getChildren().add(line);

        int beginY = 80, n = 0, step = 30;

        Label label_date = new Label("日期：" + DateHelper.formatDate(vo.getDate()));
        label_date.setLayoutX(90);
        label_date.setLayoutY(beginY + n * step);
        label_date.setTextFill(Color.WHITE);
        this.getChildren().add(label_date);
        n++;

        Label label_sumVolume = new Label("总交易量：" + vo.getVolume());
        label_sumVolume.setLayoutX(90);
        label_sumVolume.setLayoutY(beginY + n * step);
        label_sumVolume.setTextFill(Color.WHITE);
        this.getChildren().add(label_sumVolume);
        n++;

        Label label_numUpStop = new Label("涨停股票数：" + vo.getNumOfLimitUp());
        label_numUpStop.setLayoutX(90);
        label_numUpStop.setLayoutY(beginY + n * step);
        label_numUpStop.setTextFill(Color.WHITE);
        this.getChildren().add(label_numUpStop);
        n++;

        Label label_numDownStop = new Label("跌停股票数：" + vo.getNumOfLimitDown());
        label_numDownStop.setLayoutX(90);
        label_numDownStop.setLayoutY(beginY + n * step);
        label_numDownStop.setTextFill(Color.WHITE);
        this.getChildren().add(label_numDownStop);
        n++;

        Label label_numUpOver5 = new Label("涨幅超过5%股票数：" + vo.getNumOfUpOver5());
        label_numUpOver5.setLayoutX(90);
        label_numUpOver5.setLayoutY(beginY + n * step);
        label_numUpOver5.setTextFill(Color.WHITE);
        this.getChildren().add(label_numUpOver5);
        n++;


        Label label_numDownOver5 = new Label("跌幅超过5%股票数：" + vo.getNumOfDownOver5());
        label_numDownOver5.setLayoutX(90);
        label_numDownOver5.setLayoutY(beginY + n * step);
        label_numDownOver5.setTextFill(Color.WHITE);
        this.getChildren().add(label_numDownOver5);
        n++;

        Label label_numUpOverYesterday5 = new Label("波动幅度大于5%股票数：" + vo.getNumOfUpOverYesterday5());
        label_numUpOverYesterday5.setLayoutX(90);
        label_numUpOverYesterday5.setLayoutY(beginY + n * step);
        label_numUpOverYesterday5.setTextFill(Color.WHITE);
        this.getChildren().add(label_numUpOverYesterday5);
        n++;


        Label label_numDownYesterday5 = new Label("波动幅度小于5%股票数：" + vo.getNumOfDownBelowYesterday5());
        label_numDownYesterday5.setLayoutX(90);
        label_numDownYesterday5.setLayoutY(beginY + n * step);
        label_numDownYesterday5.setTextFill(Color.WHITE);
        this.getChildren().add(label_numDownYesterday5);
        n++;


        long[] num = new long[11];
        num[0] = vo.getNumOfLimitUp();
        num[1]=vo.getNumOfLimitDown();
        num[2]=vo.getNumOfUpOver5();
        num[3]=vo.getNumOfDownOver5();
        num[4]=vo.getNumOfUpOverYesterday5();
        num[5]=vo.getNumOfDownBelowYesterday5();

        /**
         * num[0-5] 涨停数，跌停数，涨幅超过5,跌幅超过5，波动幅度大于5%，波动幅度小于5%
         */

        MarketTemGraphicPane graphic = new MarketTemGraphicPane(num);
        graphic.setLayoutX(300);
        graphic.setLayoutY(180);
        me.getChildren().add(graphic);

    }


    public void initTestDate() {
        Date t = new Date();
        vo = new MarketVO(t, 0, 0, 0, 0, 0, 0, 0);

    }
}
