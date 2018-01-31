package UI.welcomeUI;

import UI.uiHelper.ImageHelper;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class FunctionSqua extends Pane {

    private FunctionSqua me = this;
    private String name, ImagePath;

    public FunctionSqua(String name, String ImagePath) {
//        me.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        me.setPrefSize(160, 160);
        me.setStyle("-fx-border-color:  #00CED1");
        me.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                me.setScaleX(1.03);
                me.setScaleY(1.03);
                me.setStyle("-fx-border-color:  #1E90FF");
            }
        });
        me.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                me.setScaleX(1);
                me.setScaleY(1);
                me.setStyle("-fx-border-color:  #00CED1");
            }
        });
        this.name = name;
        this.ImagePath = ImagePath;
        make();
    }

    public void make() {
        Label label_img = new Label("", new ImageView(ImageHelper.getImg(ImagePath)));
        label_img.setLayoutX(30);
        label_img.setLayoutY(15);
        me.getChildren().add(label_img);


        Label label_name =new Label(name);
        label_name.setLayoutY(130);
        label_name.setLayoutX(50);
        label_name.setTextFill(Color.WHITE);
        label_name.setAlignment(Pos.CENTER);
        me.getChildren().add(label_name);




    }

}
