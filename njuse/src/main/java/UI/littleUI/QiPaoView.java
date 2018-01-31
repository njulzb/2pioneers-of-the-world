package UI.littleUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class QiPaoView {
	public Pane InfoPane(String message) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("QiPaoView.fxml"));
		Pane pane =fxmlLoader.load();
		QiPaoViewController contro=fxmlLoader.getController();

		contro.init(message);

		return pane;
	}
}
