package vo;

import java.io.Serializable;
import java.util.Date;

public class StockItem implements Serializable{
    Date date;
    double open , high , low  ,close ,adjClose;
    long volume;

    public StockItem(Date date, double open, double high, double low, double close, long volume, double adjClose) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.adjClose = adjClose;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public double getAdjClose() {
        return adjClose;
    }

    public void setAdjClose(double adjClose) {
        this.adjClose = adjClose;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockItem stockItem = (StockItem) o;

        if (Double.compare(stockItem.open, open) != 0) return false;
        if (Double.compare(stockItem.high, high) != 0) return false;
        if (Double.compare(stockItem.low, low) != 0) return false;
        if (Double.compare(stockItem.close, close) != 0) return false;
        if (Double.compare(stockItem.adjClose, adjClose) != 0) return false;
        if (volume != stockItem.volume) return false;
        return date != null ? date.equals(stockItem.date) : stockItem.date == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = date != null ? date.hashCode() : 0;
        temp = Double.doubleToLongBits(open);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(high);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(low);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(close);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(adjClose);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (volume ^ (volume >>> 32));
        return result;
    }
}
