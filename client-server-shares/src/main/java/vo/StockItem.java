package vo;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StockItem implements Serializable{
    Date date;
    double open , high , low  ,close ,adjClose;
    long volume;

    public StockItem(Date date, double open, double high, double low, double close, double adjClose, long volume) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.adjClose = adjClose;
        this.volume = volume;
    }

    /**
     * 由数据表中的行直接构造
     * @param line
     */
    public StockItem(String line){
        String[] array = line.split("\t");
        String dateStr = array[1],
                openStr = array[2],
                highStr = array[3],
                lowStr = array[4],
                closeStr = array[5],
                volumeStr = array[6],
                adjCloseStr = array[7];
        DateFormat format = new SimpleDateFormat("MM/dd/yy");
        Date date = null;
        try {

            date = format.parse(dateStr);
        } catch (ParseException e1) {
            e1.printStackTrace();
            System.out.println("date format wrong");
        }
        double open = Double.parseDouble(openStr),
                high = Double.parseDouble(highStr),
                low = Double.parseDouble(lowStr),
                close = Double.parseDouble(closeStr),
                adjClose = Double.parseDouble(adjCloseStr);
        long volume = Long.parseLong(volumeStr);


        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.adjClose = adjClose;
        this.volume = volume;
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
    public String toString() {
        String result = String.format("date:%s\topen:%s\thigh:%s\tlow:%s\tclose:%s\tadj_close:%s\tvolume:%s\t",
                date,open,high,low,close,adjClose,volume);
        return result;
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
