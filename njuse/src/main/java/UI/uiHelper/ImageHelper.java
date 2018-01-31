package UI.uiHelper;

import javafx.scene.image.Image;

public class ImageHelper {
    private static String Path ="file:img\\";
    private static ImageHelper me = new ImageHelper();

    private ImageHelper() {

    }

    public  static Image getImg(String imageName){
      return   new Image(Path+imageName);
    }

}
