package UI.littleUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class CloseButton extends Pane {
    private CloseButton me = this;
    private double prefH = 15, prefW =15;
    private Stage controStage;

    public CloseButton(Stage stage) {
        controStage=stage;
        make();
    }


    private void make() {
        me.setPrefSize(40, 40);

        Line line1 = new Line(0, 0, prefW, prefH);
        line1.setStroke(Color.WHITE);
        line1.setStrokeWidth(3);
        me.getChildren().add(line1);

        Line line2 = new Line(prefW, 0, 0, prefH);
        line2.setStroke(Color.WHITE);
        line2.setStrokeWidth(3);
        me.getChildren().add(line2);


        me.setOpacity(0.8);
        me.setStyle("-fx-background:transparent;");

        this.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                me.setOpacity(1);
            }
        });
        this.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                me.setOpacity(0.8);
            }
        });
        this.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                controStage.hide();

            }
        });


    }


}
