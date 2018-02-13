package UI.graphic.compare.compare_kday;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class c_kday_oneStockCard {
    private ArrayList<Node> list = new ArrayList<Node>();


    public c_kday_oneStockCard() {

    }

    public ArrayList<Node> getList() {
        return list;
    }

    public void setAllOpacity(double op) {
        for (Node c : list) {
            c.setOpacity(op);
        }
    }

    public void hideAll() {
        for (Node c : list) {
            c.setVisible(false);
        }
    }

    public void showAll() {
        for (Node c : list) {
            c.setVisible(true);
        }
    }

    public void setAllActive() {
        for (Node c : list) {
            c.setOpacity(1);
            c.toFront();
        }
    }
    public void setAllUnActive() {
        setAllOpacity( 0.3 );
    }
}
