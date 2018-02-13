package UI.graphic.newKDay;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import vo.StockItem;
import vo.StockVO;

import java.util.ArrayList;

public class kday_mainPane extends Pane {


    public kday_mainPane me = this;
    private static double prefW = 700, prefH = 550;
    private StockVO vo;
    private LeftMessagePane leftPane;
    private Line line_Horizontal, line_Vertical;

    public kday_mainPane(StockVO vo) {
        this.vo = vo;

        make();
    }

    public void make() {
        initBackground();

        initLeftPane();
        initUpGraphic();
        initVolumeGraphic();
        initReferenceLine();
    }

    private void initReferenceLine() {

        line_Horizontal = new Line();
        line_Horizontal.setStroke(Color.DARKGRAY);
        line_Horizontal.setStrokeWidth(0.1);
        line_Horizontal.setVisible(false);
        line_Horizontal.setStartX(100);
        line_Horizontal.setEndX(prefW);
        line_Horizontal.toFront();
        me.getChildren().add(line_Horizontal);

        line_Vertical = new Line();
        line_Vertical.setStroke(Color.DARKGRAY);
        line_Vertical.setStrokeWidth(0.1);
        line_Vertical.setVisible(false);
        line_Vertical.setStartY(0);
        line_Vertical.setEndY(prefH);
        line_Vertical.toFront();
        me.getChildren().add(line_Vertical);


    }

    private void initBackground() {

        me.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        me.setPrefSize(prefW, prefH);


        me.setOnMouseMoved(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                if (e.getX() < 100 || e.getX() > prefW - 30) {
                    line_Horizontal.setVisible(false);
                    line_Vertical.setVisible(false);
                    return;
                }
                line_Horizontal.setStartY(e.getY() + 3);
                line_Horizontal.setEndY(e.getY() + 3);
                line_Horizontal.setVisible(true);

                line_Vertical.setStartX(e.getX() + 3);
                line_Vertical.setEndX(e.getX() + 3);
                line_Vertical.setVisible(true);
            }
        });

    }

    private void initUpGraphic() {
        kday_upGraphic upGraphic = new kday_upGraphic(vo, leftPane);
        upGraphic.setLayoutX(100);
        me.getChildren().add(upGraphic);
    }

    private void initLeftPane() {
        leftPane = new LeftMessagePane();
        me.getChildren().add(leftPane);
    }

    private void initVolumeGraphic() {
        kday_volumeGraphic volumeGraphic = new kday_volumeGraphic(vo, leftPane);
        volumeGraphic.setLayoutX(100);
        volumeGraphic.setLayoutY(360);
        me.getChildren().add(volumeGraphic);

    }
}
