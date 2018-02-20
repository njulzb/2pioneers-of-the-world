package UI.graphic.compare.compare_volume;

import UI.uiHelper.UISys;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Date;


public class c_volume_leftPane extends Pane {


    ArrayList<Label> labelList = new ArrayList<Label>();
    private VBox vb;
    private c_volume_leftPane me = this;
    private double preW = 100, prefH = 0;

    public c_volume_leftPane(double preW, double preH) {

        this.prefH = preH;
        this.preW = preW;
        make();

    }

    public void make() {
        me.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        ScrollPane sp = new ScrollPane();
        sp.setLayoutX(0);
        sp.setLayoutY(0);
        sp.setMinWidth(preW - sp.getLayoutX());
        sp.setMaxWidth(preW - sp.getLayoutX());
        sp.setMaxHeight(prefH - sp.getLayoutY());
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
        sp.setContent(vb);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);

        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        me.getChildren().add(sp);
    }

    public void update(ArrayList<Double> volumesList, ArrayList<String> stockNameList, Date date) {
        for (int i = 0; i < volumesList.size(); i++) {
            Label c = new Label(stockNameList.get(i) + " " + volumesList.get(i));
        }
        
    }

    public void clear() {


    }
}
