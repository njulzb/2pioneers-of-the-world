package UI.stockUI;

import UI.aaManager.StockSelectManager;
import UI.littleUI.DragTitlePane;
import UI.littleUI.MyButton;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class StockSelectUI extends DragTitlePane {
    private StockSelectUI me = this;
    private StockSelectManager manager = new StockSelectManager(me);
    private 	DatePicker startDatePicker, endDatePicker;

    public StockSelectUI() {
        me.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        me.setPrefSize(800, 600);
        make();
    }

    public void make() {
        Label label_title = new Label("搜索股票");
        label_title.setLayoutX(30);
        label_title.setLayoutY(20);
        label_title.setTextFill(Color.WHITE);
        me.getChildren().add(label_title);

        Pane line = new Pane();
        line.setLayoutX(20);
        line.setLayoutY(40);
        line.setPrefSize(720, 2);
        line.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, null, null)));
        me.getChildren().add(line);


        Label label_search = new Label("输入名称或代码");
        label_search.setLayoutX(120);
        label_search.setLayoutY(80);
        label_search.setTextFill(Color.WHITE);
        me.getChildren().add(label_search);


        TextField tf_search = new TextField();
        tf_search.setLayoutX(250);
        tf_search.setLayoutY(80);
        me.getChildren().add(tf_search);

        Label label_startTime = new Label("起始时间");
        label_startTime.setLayoutX(120);
        label_startTime.setLayoutY(110);
        label_startTime.setTextFill(Color.WHITE);
        me.getChildren().add(label_startTime);

        startDatePicker = new DatePicker();
        startDatePicker.setLayoutX(250);
        startDatePicker.setLayoutY(110);
        startDatePicker.setMaxWidth(140);
        me.getChildren().add(startDatePicker);


        Label label_endTime = new Label("结束时间");
        label_endTime.setLayoutX(120);
        label_endTime.setLayoutY(140);
        label_endTime.setTextFill(Color.WHITE);
        me.getChildren().add(label_endTime);

        endDatePicker = new DatePicker();
        endDatePicker.setLayoutX(250);
        endDatePicker.setLayoutY(140);
        endDatePicker.setMaxWidth(140);
        me.getChildren().add(endDatePicker);



        MyButton button_search = new MyButton("确认", 20, 80);
        button_search.setLayoutX(320);
        button_search.setLayoutY(170);
        button_search.setOnAction((ActionEvent event) -> {
            manager.searchStock(tf_search.getText().trim(),startDatePicker.getValue(),endDatePicker.getValue());

        });
        me.getChildren().add(button_search);


    }

    public void showSerachResult(){

        double spW=720,spH=300;

        ScrollPane sp = new ScrollPane();
        sp.getStyleClass().add("edge-to-edge");
        sp.setStyle(" -fx-background-color: transparent;");
        sp.setStyle("-fx-border-color:  #00FF00");
        sp.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        sp.setLayoutX(40);
        sp.setLayoutY(130);
        sp.setMinWidth(spW);
        sp.setMaxWidth(spW);
        sp.setMinHeight(spH);
        sp.setMaxHeight(spH);

        VBox vb = new VBox();
        vb.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        sp.setVmax(spH);
        sp.setPrefSize(spW, spW);
        sp.setContent(vb);
        me.getChildren().add(sp);
    }
    public void showRandom(){

    }





}
