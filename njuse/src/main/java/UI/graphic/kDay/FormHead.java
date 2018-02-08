package UI.graphic.kDay;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class FormHead extends Pane {
    private FormHead me = this;
    private int KDnum = 5;
    private double h = Kday_graphicPane.prefH_up;

    public FormHead(double scale) {
        me.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        Pane line = new Pane();
        line.setPrefSize(1, h);
        line.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));

        me.getChildren().add(line);

//从下往上画刻度
        for (int i = 0; i < KDnum; i++) {
            Pane line_KD = new Pane();
            line_KD.setPrefSize(10, 1);
            line_KD.setLayoutY((KDnum - i) * h / KDnum);
            line_KD.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
            me.getChildren().add(line_KD);

            Label label_KD = new Label("" + i * h / KDnum * scale);
            label_KD.setLayoutX(35);
            label_KD.setLayoutY(((KDnum - i) * h / KDnum)-10);
            label_KD.setTextFill(Color.GRAY);
            me.getChildren().add(label_KD);

        }


    }
}
