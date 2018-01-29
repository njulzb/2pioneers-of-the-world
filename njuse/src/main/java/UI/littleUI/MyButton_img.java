package UI.littleUI;

import UI.uiHelper.ImageHelper;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class MyButton_img extends Label {
    private MyButton_img me = this;



    public MyButton_img(String imagePath) {
        super("", new ImageView(ImageHelper.getImg(imagePath)));
        me.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                me.setScaleX(1.3);
                me.setScaleY(1.3);
            }
        });
        me.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                me.setScaleX(1);
                me.setScaleY(1);
            }
        });
    }


}
