package vo;

import java.util.Date;

public class LogRateItem {
    private Date date;
    private double logRate;

    public LogRateItem(Date date, double logRate) {
        this.date = date;
        this.logRate = logRate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getLogRate() {
        return logRate;
    }

    public void setLogRate(double logRate) {
        this.logRate = logRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogRateItem that = (LogRateItem) o;

        if (Double.compare(that.logRate, logRate) != 0) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = date != null ? date.hashCode() : 0;
        temp = Double.doubleToLongBits(logRate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "LogRateItem{" +
                "date=" + date +
                ", logRate=" + logRate +
                '}';
    }
}
