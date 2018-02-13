package UI.stockUI;

import UI.aaManager.StockSelectManager;
import UI.littleUI.CloseButton;
import UI.littleUI.DragTitlePane;
import UI.littleUI.MyButton;
import UI.loginUI.LoginPane;
import UI.uiHelper.ImageHelper;
import UI.uiHelper.UISys;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import resultMsg.StockResultMsg;
import vo.StockVO;

import java.time.LocalDate;

public class StockSelectWindows extends Application {
    public Pane root = new Pane();
    private Stage thisStage;
    private double windowsH = 300, windownsW = 500;
    private DatePicker startDatePicker, endDatePicker;
    private StockSelectManager manage = new StockSelectManager(this);
    public StockResultMsg stockResultMsg = null;

    public StockSelectWindows() {

        makeUI();

    }


    public static void main(String[] args) {
        Application.launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        root.setStyle("-fx-border-color:  #FFFFFF");
        Scene scene = new Scene(root, windownsW, windowsH);
        this.thisStage = primaryStage;
        primaryStage.initStyle(StageStyle.TRANSPARENT);// 无边框
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setScene(scene);

        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public void showSelector() {
        thisStage = new Stage();
        root.setStyle("-fx-border-color:  #FFFFFF");
        Scene scene = new Scene(root, windownsW, windowsH);

        thisStage.initStyle(StageStyle.TRANSPARENT);// 无边框
        thisStage.setAlwaysOnTop(true);
        thisStage.setScene(scene);


        thisStage.setResizable(false);
        thisStage.initModality(Modality.APPLICATION_MODAL);
        thisStage.showAndWait();


    }


    public void makeUI() {

        root.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        root.setPrefSize(windownsW, windowsH);


        CloseButton closeButton = new CloseButton(thisStage);
        closeButton.setLayoutX(windownsW-50);
        closeButton.setLayoutY(10);
        closeButton.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                thisStage.hide();
            }
        });

        root.getChildren().add(closeButton);


        Label label_title = new Label("搜索股票");
        label_title.setLayoutX(30);
        label_title.setLayoutY(20);
        label_title.setTextFill(Color.WHITE);
        root.getChildren().add(label_title);

        Pane line = new Pane();
        line.setLayoutX(20);
        line.setLayoutY(40);
        line.setPrefSize(windownsW - 40, 2);
        line.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, null, null)));
        root.getChildren().add(line);


        Label label_search = new Label("输入名称或代码");
        label_search.setLayoutX(120);
        label_search.setLayoutY(80);
        label_search.setTextFill(Color.WHITE);
        root.getChildren().add(label_search);


        TextField tf_search = new TextField();
        tf_search.setText(1 + "");
        tf_search.setLayoutX(250);
        tf_search.setLayoutY(80);
        root.getChildren().add(tf_search);

        Label label_startTime = new Label("起始时间");
        label_startTime.setLayoutX(120);
        label_startTime.setLayoutY(110);
        label_startTime.setTextFill(Color.WHITE);
        root.getChildren().add(label_startTime);


        startDatePicker = new DatePicker();
        startDatePicker.setLayoutX(250);
        startDatePicker.setLayoutY(110);
        startDatePicker.setMaxWidth(140);
        startDatePicker.setValue(LocalDate.of(2013, 3, 3));
        root.getChildren().add(startDatePicker);


        Label label_endTime = new Label("结束时间");
        label_endTime.setLayoutX(120);
        label_endTime.setLayoutY(140);
        label_endTime.setTextFill(Color.WHITE);
        root.getChildren().add(label_endTime);


        endDatePicker = new DatePicker();
        endDatePicker.setLayoutX(250);
        endDatePicker.setLayoutY(140);
        endDatePicker.setMaxWidth(140);
        endDatePicker.setValue(LocalDate.of(2013, 4, 23));
        root.getChildren().add(endDatePicker);


        MyButton button_search = new MyButton("确认", 20, 80);
        button_search.setLayoutX(320);
        button_search.setLayoutY(170);
        button_search.setOnAction((ActionEvent event) -> {
            stockResultMsg = manage.searchStock(tf_search.getText().trim(), startDatePicker.getValue(), endDatePicker.getValue());
            thisStage.hide();
        });
        root.getChildren().add(button_search);


    }
}