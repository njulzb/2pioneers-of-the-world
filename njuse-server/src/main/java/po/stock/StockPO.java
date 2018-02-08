package po.stock;

import vo.StockItem;

import java.io.Serializable;
import java.util.ArrayList;

public class StockPO implements Serializable{

    String code,name, market;

    ArrayList<StockItem> stockItemArrayList;

    public StockPO(String code, String name, String market, ArrayList<StockItem> stockItemArrayList) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockPO stockPO = (StockPO) o;

        if (code != null ? !code.equals(stockPO.code) : stockPO.code != null) return false;
        if (name != null ? !name.equals(stockPO.name) : stockPO.name != null) return false;
        if (market != null ? !market.equals(stockPO.market) : stockPO.market != null) return false;
        return stockItemArrayList != null ? stockItemArrayList.equals(stockPO.stockItemArrayList) : stockPO.stockItemArrayList == null;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (market != null ? market.hashCode() : 0);
        result = 31 * result + (stockItemArrayList != null ? stockItemArrayList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StockPO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", market='" + market + '\'' +
                ", stockItemArrayList=" + stockItemArrayList +
                '}';
    }
}
