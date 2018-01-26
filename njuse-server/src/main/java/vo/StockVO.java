package vo;

import java.util.ArrayList;

/**
 *
 */
public class StockVO {
    String code,name,marktet;

    ArrayList<StockItem> stockItemArrayList;

    public StockVO(String code, String name, String marktet, ArrayList<StockItem> stockItemArrayList) {
        this.code = code;
        this.name = name;
        this.marktet = marktet;
        this.stockItemArrayList = stockItemArrayList;
    }

    public ArrayList<StockItem> getStockItemArrayList() {
        return stockItemArrayList;
    }

    public void setStockItemArrayList(ArrayList<StockItem> stockItemArrayList) {
        this.stockItemArrayList = stockItemArrayList;
    }
}
