package vo;


import java.io.Serializable;
import java.util.Date;

public class MarketVO implements Serializable {
    Date date;
    long volume=0 ;// 交易量
    long numOfLimitUp=0,numOfLimitDown=0;//涨停，跌停 股票数
    long numOfUpOver5=0 ,numOfDownOver5=0;//涨幅超过5%，跌幅超过5%的股票数
    long numOfUpOverYesterday5=0 ,numOfDownBelowYesterday5=0;//，开盘‐收盘大于 5%*上一个交易日收盘价的 股票个数


    public MarketVO(Date date, long volume, long numOfLimitUp, long numOfLimitDown, long numOfUpOver5, long numOfDownOver5, long numOfUpOverYesterday5, long numOfDownBelowYesterday5) {
        this.date = date;
        this.volume = volume;
        this.numOfLimitUp = numOfLimitUp;
        this.numOfLimitDown = numOfLimitDown;
        this.numOfUpOver5 = numOfUpOver5;
        this.numOfDownOver5 = numOfDownOver5;
        this.numOfUpOverYesterday5 = numOfUpOverYesterday5;
        this.numOfDownBelowYesterday5 = numOfDownBelowYesterday5;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public long getNumOfLimitUp() {
        return numOfLimitUp;
    }

    public void setNumOfLimitUp(long numOfLimitUp) {
        this.numOfLimitUp = numOfLimitUp;
    }

    public long getNumOfLimitDown() {
        return numOfLimitDown;
    }

    public void setNumOfLimitDown(long numOfLimitDown) {
        this.numOfLimitDown = numOfLimitDown;
    }

    public long getNumOfUpOver5() {
        return numOfUpOver5;
    }

    public void setNumOfUpOver5(long numOfUpOver5) {
        this.numOfUpOver5 = numOfUpOver5;
    }

    public long getNumOfDownOver5() {
        return numOfDownOver5;
    }

    public void setNumOfDownOver5(long numOfDownOver5) {
        this.numOfDownOver5 = numOfDownOver5;
    }

    public long getNumOfUpOverYesterday5() {
        return numOfUpOverYesterday5;
    }

    public void setNumOfUpOverYesterday5(long numOfUpOverYesterday5) {
        this.numOfUpOverYesterday5 = numOfUpOverYesterday5;
    }

    public long getNumOfDownBelowYesterday5() {
        return numOfDownBelowYesterday5;
    }

    public void setNumOfDownBelowYesterday5(long numOfDownBelowYesterday5) {
        this.numOfDownBelowYesterday5 = numOfDownBelowYesterday5;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarketVO marketVO = (MarketVO) o;

        if (volume != marketVO.volume) return false;
        if (numOfLimitUp != marketVO.numOfLimitUp) return false;
        if (numOfLimitDown != marketVO.numOfLimitDown) return false;
        if (numOfUpOver5 != marketVO.numOfUpOver5) return false;
        if (numOfDownOver5 != marketVO.numOfDownOver5) return false;
        if (numOfUpOverYesterday5 != marketVO.numOfUpOverYesterday5) return false;
        if (numOfDownBelowYesterday5 != marketVO.numOfDownBelowYesterday5) return false;
        return date != null ? date.equals(marketVO.date) : marketVO.date == null;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (int) (volume ^ (volume >>> 32));
        result = 31 * result + (int) (numOfLimitUp ^ (numOfLimitUp >>> 32));
        result = 31 * result + (int) (numOfLimitDown ^ (numOfLimitDown >>> 32));
        result = 31 * result + (int) (numOfUpOver5 ^ (numOfUpOver5 >>> 32));
        result = 31 * result + (int) (numOfDownOver5 ^ (numOfDownOver5 >>> 32));
        result = 31 * result + (int) (numOfUpOverYesterday5 ^ (numOfUpOverYesterday5 >>> 32));
        result = 31 * result + (int) (numOfDownBelowYesterday5 ^ (numOfDownBelowYesterday5 >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "MarketVO{" +
                "date=" + date +
                ", volume=" + volume +
                ", numOfLimitUp=" + numOfLimitUp +
                ", numOfLimitDown=" + numOfLimitDown +
                ", numOfUpOver5=" + numOfUpOver5 +
                ", numOfDownOver5=" + numOfDownOver5 +
                ", numOfUpOverYesterday5=" + numOfUpOverYesterday5 +
                ", numOfDownBelowYesterday5=" + numOfDownBelowYesterday5 +
                '}';
    }
}
