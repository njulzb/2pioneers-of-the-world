package UI.stockUI;

import UI.graphic.compare.compare_kday.c_kday_mainPane;
import UI.uiHelper.UISys;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import resultMsg.StockResultMsg;
import vo.StockVO;

import java.sql.Timestamp;
import java.util.ArrayList;

public class StockCompareUI extends Pane {

    private StockCompareUI me = this;
    private ArrayList<StockResultMsg> stockResultMsgList = new ArrayList<StockResultMsg>();
    private ScrollPane sp;
    private VBox vb;

    public StockCompareUI(ArrayList<StockResultMsg> stockResultMsgList) {
        if (stockResultMsgList == null || stockResultMsgList.size() == 0) {
            System.out.println("error!在构造StockCompareUI时传入了null或者size为0的arrayList");
            System.exit(0);
        }
        this.stockResultMsgList = stockResultMsgList;
        make();


    }

    private void make() {
        initBackground();
        initTitle();
        initKdayGraphicPane();

    }

    private void initBackground() {
        me.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        me.setPrefSize(UISys.getWindowsW(), UISys.getWindowsH());


        sp = new ScrollPane();
        sp.setLayoutX(40);
        sp.setLayoutY(60);
        sp.setMinWidth(UISys.getWindowsW() - sp.getLayoutX());
        sp.setMaxWidth(UISys.getWindowsW() - sp.getLayoutX());
//        sp.setMinHeight(UISys.getWindowsH() - sp.getLayoutY());
        sp.setMaxHeight(UISys.getWindowsH() - sp.getLayoutY());
        sp.setStyle("   -fx-padding: 0;  " +
                "-fx-background-insets: 0; " +
                "-fx-background-color: transparent;" +
                "  -fx-control-inner-background: transparent;  ");
        sp.setStyle("-fx-background-color: transparent;");

        vb = new VBox();
        vb.setStyle("   -fx-padding: 0;  " +
                "-fx-background-insets: 0; " +
                "-fx-background-color: transparent;" +
                "  -fx-control-inner-background: transparent;  ");
//        sp.setVmax(440);
//        sp.setPrefSize(115, 150);
        sp.setContent(vb);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        me.getChildren().add(sp);

    }

    private void initTitle() {
        Timestamp nowTime = new Timestamp(System.currentTimeMillis());

        String strTitle = " ";
        for (StockResultMsg ms : stockResultMsgList) {
            strTitle = strTitle + " " + ms.getStockVO().getName();

        }
        Label label_nowTime = new Label("股票比较： " + strTitle);
        label_nowTime.setLayoutX(50);
        label_nowTime.setLayoutY(18);
        label_nowTime.setTextFill(Color.WHITE);
        me.getChildren().add(label_nowTime);

        Pane line = new Pane();
        line.setLayoutX(40);
        line.setLayoutY(40);
        line.setPrefSize(720, 2);
        line.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, null, null)));
        me.getChildren().add(line);
    }

    private void initKdayGraphicPane() {
        SecondTitlePane kday_st = new SecondTitlePane("日k线");

        vb.getChildren().add(kday_st);


        ArrayList<StockVO> li = new ArrayList<StockVO>();

        for (StockResultMsg ms : stockResultMsgList) {
            li.add(ms.getStockVO());
        }

        c_kday_mainPane pane = new c_kday_mainPane(li);
        pane.setPrefWidth(sp.getMaxWidth());
        vb.getChildren().add(pane);


    }

    class SecondTitlePane extends Pane {


        public SecondTitlePane(String name) {
            this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

            this.setPrefSize(sp.getWidth(), 70);


            Label label_st = new Label(name);
            label_st.setLayoutX(14);
            label_st.setLayoutY(10);
            label_st.setFont(new Font(19));
            label_st.setTextFill(Color.WHITE);
            this.getChildren().add(label_st);

            Pane line_shu = new Pane();
            line_shu.setLayoutX(0);
            line_shu.setLayoutY(15);
            line_shu.setPrefSize(9, 9);
            line_shu.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
            this.getChildren().add(line_shu);

//            Pane line_heng = new Pane();
//            line_heng.setLayoutX(50);
//            line_heng.setLayoutY(41);
//            line_heng.setPrefSize(600, 1);
//            line_heng.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
//            this.getChildren().add(line_heng);
        }

    }
}
