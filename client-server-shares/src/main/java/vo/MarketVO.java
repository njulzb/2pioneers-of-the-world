package vo;

import java.util.Date;

public class MarketVO {
    Date date;
    long volume ;// 交易量
    long numOfLimitUp,numOfLimitDown;
    long numOfUpOver5 ,numOfDownOver5;
    long numOfUpOverYesterday5 ,numOfDownBelowYesterday5;

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
}
