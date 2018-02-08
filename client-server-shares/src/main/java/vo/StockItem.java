package vo;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StockItem implements Serializable{

    String serial,code,name,market;
    Date date;
    double open , high , low  ,close ,adjClose;
    long volume;

    public StockItem(String serial, String code, String name, String market, Date date, double open, double high, double low, double close, double adjClose, long volume) {
        this.serial = serial;
        this.code = code;
        this.name = name;
        this.market = market;
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
        String serialStr = array[0],
                dateStr = array[1],
                openStr = array[2],
                highStr = array[3],
                lowStr = array[4],
                closeStr = array[5],
                volumeStr = array[6],
                adjCloseStr = array[7],
                codeStr = array[8],
                nameStr = array[9],
                marketStr = array[10];
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


        this.serial = serialStr;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.adjClose = adjClose;
        this.volume = volume;
        this.code = codeStr;
        this.name = nameStr;
        this.market = marketStr;
    }


    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
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

    public double getAdjClose() {
        return adjClose;
    }

    public void setAdjClose(double adjClose) {
        this.adjClose = adjClose;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
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
        if (serial != null ? !serial.equals(stockItem.serial) : stockItem.serial != null) return false;
        if (code != null ? !code.equals(stockItem.code) : stockItem.code != null) return false;
        if (name != null ? !name.equals(stockItem.name) : stockItem.name != null) return false;
        if (market != null ? !market.equals(stockItem.market) : stockItem.market != null) return false;
        return date != null ? date.equals(stockItem.date) : stockItem.date == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = serial != null ? serial.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (market != null ? market.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
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


    @Override
    public String toString() {
        return "StockItem{" +
                "serial='" + serial + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", market='" + market + '\'' +
                ", date=" + date +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", adjClose=" + adjClose +
                ", volume=" + volume +
                '}';
    }
}
