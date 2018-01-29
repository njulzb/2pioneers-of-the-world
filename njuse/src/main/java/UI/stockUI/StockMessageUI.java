package UI.stockUI;

import UI.graphic.kDay.Kday_graphicPane;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import vo.StockItem;

public class StockMessageUI extends Pane {
    private StockMessageUI me =this;
    public StockMessageUI() {
        me.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        me.setPrefSize(800, 600);
        make();
    }

    public void make() {
        Label label_stockName = new Label("茅台集团");
        label_stockName.setLayoutX(80);
        label_stockName.setLayoutY(40);
        label_stockName.setTextFill(Color.WHITE);
        this.getChildren().add(label_stockName);

        Kday_graphicPane graPane =new Kday_graphicPane();
        this.getChildren().add(graPane);
        graPane.setLayoutX(80);
        graPane.setLayoutY(100);


    }

}
