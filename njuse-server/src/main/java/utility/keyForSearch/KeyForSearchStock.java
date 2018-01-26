package utility.keyForSearch;

import java.util.Date;

public class KeyForSearchStock {
   public  Date begin,end;
   public String stockID , stockName;

    public KeyForSearchStock(Date begin, Date end, String stockID, String stockName) {
        this.begin = begin;
        this.end = end;
        this.stockID = stockID;
        this.stockName = stockName;
    }

    //getter and setter below

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getStockID() {
        return stockID;
    }

    public void setStockID(String stockID) {
        this.stockID = stockID;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    //getter and setter above
}
