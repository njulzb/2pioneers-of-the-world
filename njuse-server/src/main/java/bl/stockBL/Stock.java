package bl.stockBL;

import po.stock.StockPO;
import vo.StockItem;
import vo.StockVO;

import java.util.ArrayList;

public class Stock {
    String code,name, market;

    ArrayList<StockItem> stockItemArrayList = new ArrayList<>();

    public Stock(StockPO po){
        this.code = po.getCode();
        this.name = po.getName();
        this.market = po.getMarket();
        this.stockItemArrayList.addAll(po.getStockItemArrayList());
    }

    public Stock(StockVO vo){
        this.code = vo.getCode();
        this.name = vo.getName();
        this.market = vo.getMarket();
        this.stockItemArrayList.addAll(vo.getStockItemArrayList());
    }

    public Stock(String code, String name, String market, ArrayList<StockItem> stockItemArrayList) {
        this.code = code;
        this.name = name;
        this.market = market;
        this.stockItemArrayList = stockItemArrayList;
    }

    public StockPO toPO(){
        ArrayList<StockItem> stockItemArrayList = new ArrayList<>();
        stockItemArrayList.addAll(this.stockItemArrayList);
        StockPO po = new StockPO(this.code,this.name,this.market,stockItemArrayList);
        return po;
    }

    public StockVO toVO(){
        ArrayList<StockItem> stockItemArrayList = new ArrayList<>();
        stockItemArrayList.addAll(this.stockItemArrayList);
        StockVO vo = new StockVO(this.code,this.name,this.market,stockItemArrayList);
        return vo;
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

        Stock stock = (Stock) o;

        if (code != null ? !code.equals(stock.code) : stock.code != null) return false;
        if (name != null ? !name.equals(stock.name) : stock.name != null) return false;
        if (market != null ? !market.equals(stock.market) : stock.market != null) return false;
        return stockItemArrayList != null ? stockItemArrayList.equals(stock.stockItemArrayList) : stock.stockItemArrayList == null;
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
        return "Stock{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", market='" + market + '\'' +
                ", stockItemArrayList=" + stockItemArrayList +
                '}';
    }
}
