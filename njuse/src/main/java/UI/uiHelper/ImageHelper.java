package UI.uiHelper;

import javafx.scene.image.Image;

public class ImageHelper {
    private static String Path ="img\\";
    private static ImageHelper me = new ImageHelper();

    private ImageHelper() {

    }

    public  static Image getImg(String imageName){
      return   new Image(me.getClass().getResourceAsStream(Path+imageName));
    }

}
