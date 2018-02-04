package UI.stockUI;

import UI.graphic.kDay.Kday_graphicPane;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import vo.StockItem;
import vo.StockVO;

public class StockMessageUI extends Pane {
    private StockMessageUI me = this;
    private String name = "default公司", code = "000000";
    private StockVO vo;

    public StockMessageUI(StockVO vo) {
        if (vo != null) {
            this.vo = vo;
        }


        me.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        me.setPrefSize(800, 600);
        make();
    }

    public void make() {
        Label label_stockName = new Label(name);
        label_stockName.setLayoutX(50);
        label_stockName.setLayoutY(20);
        label_stockName.setTextFill(Color.WHITE);
        this.getChildren().add(label_stockName);

        Label label_stockCode = new Label("   股票代码：" + code);
        label_stockCode.setLayoutX(260);
        label_stockCode.setLayoutY(20);
        label_stockCode.setTextFill(Color.WHITE);
        this.getChildren().add(label_stockCode);


        Pane line = new Pane();
        line.setLayoutX(40);
        line.setLayoutY(40);
        line.setPrefSize(720, 2);
        line.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, null, null)));
        me.getChildren().add(line);


        Kday_graphicPane graPane = new Kday_graphicPane(vo);
        this.getChildren().add(graPane);
        graPane.setLayoutX(60);
        graPane.setLayoutY(80);


    }

}
