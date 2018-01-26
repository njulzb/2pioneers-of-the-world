package UI.littleUI;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DragTitlePane extends Pane {
    double xOffset = 0;
    double yOffset = 0;

    public DragTitlePane(Stage stage) {

        this.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                e.consume();
                xOffset = e.getSceneX();
                yOffset = e.getSceneY();
            }
        });
        this.setOnMouseDragged(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e) {
                e.consume();
                stage.setX(e.getScreenX() - xOffset);
                // 根据自己的需求，做不同的判断
                if (e.getScreenY() - yOffset < 0) {
                    stage.setY(0);

                } else {
                    stage.setY(e.getScreenY() - yOffset);
                }

            }
        });
    }


}
