package UI.stockUI;

import UI.aaManager.StockMessageManager;
import UI.graphic.newKDay.kday_mainPane;
import UI.graphic.newKDay.kday_upGraphic;
import UI.littleUI.DragTitlePane;
import UI.littleUI.MyButton;
import UI.uiHelper.DateHelper;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import resultMsg.StockResultMsg;
import vo.StockItem;
import vo.StockVO;

import java.time.LocalDate;

public class StockMessageUI extends DragTitlePane {
    private StockMessageUI me = this;
    private String name = "default公司", code = "000000";
    private StockVO vo;
    public StockResultMsg smsg;
    private StockMessageManager manager = new StockMessageManager(me);
    private DatePicker startDatePicker, endDatePicker;

    public StockMessageUI(StockResultMsg smsg) {
        super();

        if (smsg != null) {
            this.smsg = smsg;
            this.vo = smsg.getStockVO();
            this.name = vo.getName();
            this.code = vo.getCode();
        }


        me.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        me.setPrefSize(800, 600);
        make();

    }

    private void make() {

        initTitle();
        kday_mainPane graPane = new kday_mainPane(vo);

        this.getChildren().add(graPane);
        graPane.setLayoutX(40);
        graPane.setLayoutY(70);


    }

    private void initTitle() {
        Label label_stockName = new Label(name);
        label_stockName.setLayoutX(50);
        label_stockName.setLayoutY(20);
        label_stockName.setTextFill(Color.WHITE);
        this.getChildren().add(label_stockName);

        Label label_stockCode = new Label("   股票代码：" + code);
        label_stockCode.setLayoutX(150);
        label_stockCode.setLayoutY(20);
        label_stockCode.setTextFill(Color.WHITE);
        this.getChildren().add(label_stockCode);


        LocalDate startD = DateHelper.DateToLocalDate(vo.getStockItemArrayList().get(0).getDate());
        LocalDate endD = DateHelper.DateToLocalDate(vo.getStockItemArrayList().get(vo.getStockItemArrayList().size() - 1).getDate());

        startDatePicker = new DatePicker();
        startDatePicker.setLayoutX(270);
        startDatePicker.setLayoutY(18);
        startDatePicker.setMaxWidth(120);
        startDatePicker.setValue(startD);
        me.getChildren().add(startDatePicker);


        endDatePicker = new DatePicker();
        endDatePicker.setLayoutX(430);
        endDatePicker.setLayoutY(18);
        endDatePicker.setMaxWidth(120);
        endDatePicker.setValue(endD);
        me.getChildren().add(endDatePicker);


        MyButton button_reSearch = new MyButton("重新查询", 20, 70);
        button_reSearch.setLayoutX(573);
        button_reSearch.setLayoutY(18);
        button_reSearch.setOnAction((ActionEvent event) -> {
            manager.reSearch(startDatePicker.getValue(), endDatePicker.getValue(), this.code);
        });
        me.getChildren().add(button_reSearch);


        MyButton button_compare = new MyButton("股票比较", 20, 70);
        button_compare.setLayoutX(670);
        button_compare.setLayoutY(18);
        button_compare.setOnAction((ActionEvent event) -> {
            manager.compare();
        });
        me.getChildren().add(button_compare);


        Pane line = new Pane();
        line.setLayoutX(40);
        line.setLayoutY(47);
        line.setPrefSize(720, 2);
        line.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, null, null)));
        me.getChildren().add(line);


    }

}
