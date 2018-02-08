package UI.littleUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

public class QiPaoView {
    public Pane InfoPane(String message) throws IOException {
        System.out.println(getClass().getResource(""));

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("QiPaoView.fxml"));
        Pane pane = fxmlLoader.load();
//        URL url = getClass().getResource("QiPaoView.fxml");
//        Pane pane = FXMLLoader.load(url);


        QiPaoViewController contro = fxmlLoader.getController();

        contro.init(message);

        return pane;
    }
}
