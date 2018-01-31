package UI.marketTemUI;

import UI.graphic.kDay.Kday_graphicPane;
import UI.stockUI.StockMessageUI;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import vo.MarketVO;
import vo.StockVO;

public class MarketTemMainUI extends Pane {
    private MarketTemMainUI me = this;
    private MarketVO vo;

    public MarketTemMainUI(MarketVO vo) {
        if (vo != null) {
            this.vo = vo;
        } else {

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





    }
}
