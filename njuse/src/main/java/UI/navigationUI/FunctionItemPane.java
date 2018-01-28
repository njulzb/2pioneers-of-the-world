package UI.navigationUI;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class FunctionItemPane extends Pane {
    private FunctionItemPane me = this;

    public FunctionItemPane(String functionName) {
        me.setPrefSize(100,40);
        this.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                Pane obj = (Pane) e.getSource();
                obj.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
            }
        });
        this.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                Pane obj = (Pane) e.getSource();
                obj.setBackground(null);
            }
        });

        Line upLine = new Line();
        upLine.setStartX(0);
        upLine.setStartY(1);
        upLine.setFill(Color.WHITE);
        upLine.setEndX(NavigationPane.NavigationWidth);
        upLine.setEndY(1);
        me.getChildren().add(upLine);

        Label label_fName = new Label(functionName);
        label_fName.setPrefSize(NavigationPane.NavigationWidth, 18);
        label_fName.setFont(new Font(15));

        label_fName.setLayoutX(10);
        label_fName.setLayoutY(13);
        label_fName.setTextFill(Color.WHITE);
        this.getChildren().add(label_fName);

    }

}