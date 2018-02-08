package vo;

import java.util.ArrayList;

/**
 *
 */
public class StockVO {
    String code,name, market;

    ArrayList<StockItem> stockItemArrayList;

    public StockVO(String code, String name, String market, ArrayList<StockItem> stockItemArrayList) {
        this.code = code;
        this.name = name;
        this.market = market;
        this.stockItemArrayList = stockItemArrayList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public ArrayList<StockItem> getStockItemArrayList() {
        return stockItemArrayList;
    }

    public void setStockItemArrayList(ArrayList<StockItem> stockItemArrayList) {
        this.stockItemArrayList = stockItemArrayList;
    }
}
