package resultMsg;

import vo.LogRateItem;
import vo.StockItem;
import vo.StockVO;

import java.util.*;

public class StockResultMsg extends ResultMsg {

    private StockVO stockVO ;
    private Date begin,end;
    private double lowest,highest,increase;//这段时间内的最低值，最高值，涨幅/跌幅，（涨幅为正，跌幅为负，以%为单位）
    private ArrayList<LogRateItem> logRateList;
    double logVariance;//每天的对数收益率，和对数收益率方差



    public StockResultMsg(boolean flag, String errorMsg, StockVO stockVO) {
        super(flag, errorMsg);
        this.stockVO = stockVO;

        //以下生成对应的分析数据
        if (stockVO == null || stockVO.getStockItemArrayList()==null || stockVO.getStockItemArrayList().size()==0) {
            return ;
        }

        this.initialize();

    }

    private void initialize(){
        //以下生成对应的分析数据
        //  1.进行排序
        ArrayList<StockItem> itemArrayList = this.stockVO.getStockItemArrayList();
        Comparator<StockItem> comparator = (x,y)->{
            boolean result  = x.getDate().before(y.getDate());
            if (result){
                return -1;
            }
            else{
                return 1;
            }
        };
        itemArrayList.sort(comparator);
        // 2.赋值
        new Thread(()->{
            StockItem firstItem = itemArrayList.get(0),
                    lastItem = itemArrayList.get(itemArrayList.size()-1);
            this.begin = firstItem.getDate();
            this.end = lastItem.getDate();
            this.increase = ( (lastItem.getClose() )-( firstItem.getClose() ))/
                    (firstItem.getClose())*100;

        }).start();
        //3.遍历
        this.lowest = Double.MAX_VALUE;
        this.highest = -1;//最低值和最高值都不可能为负数

        //highest
        new Thread(()->{
            for (StockItem eItem : itemArrayList) {
                if (eItem.getHigh()>this.highest){
                    this.highest = eItem.getHigh();
                }
            }
        }).start();

        //lowest
        new Thread(()->{
            for (StockItem eItem : itemArrayList) {
                if (eItem.getLow() < this.lowest){
                    this.lowest = eItem.getLow();
                }
            }
        }).start();

        //log List and variance
        this.logRateList = new ArrayList<>();
        new Thread(()->{
            double sum =0;
            for (int i=1;i<itemArrayList.size();i++){
                StockItem before = itemArrayList.get(i-1) , curr = itemArrayList.get(i);
                double logRate = Math.log(curr.getClose() - before.getClose());
                LogRateItem logRateItem = new LogRateItem(curr.getDate(),logRate);
                this.logRateList.add(logRateItem);

                sum += logRate;

            }
            double average = sum/this.logRateList.size();
            double squareSum = 0;
            for (LogRateItem eLogRateItem : this.logRateList) {
                squareSum += (eLogRateItem.getLogRate()-average) * (eLogRateItem.getLogRate()-average);
            }
            this.logVariance = squareSum/this.logRateList.size();
        }).start();


    }

    public StockVO getStockVO() {
        return stockVO;
    }

    public void setStockVO(StockVO stockVO) {
        this.stockVO = stockVO;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockResultMsg resultMsg = (StockResultMsg) o;

        if (Double.compare(resultMsg.lowest, lowest) != 0) return false;
        if (Double.compare(resultMsg.highest, highest) != 0) return false;
        if (Double.compare(resultMsg.increase, increase) != 0) return false;
        if (Double.compare(resultMsg.logVariance, logVariance) != 0) return false;
        if (stockVO != null ? !stockVO.equals(resultMsg.stockVO) : resultMsg.stockVO != null) return false;
        if (begin != null ? !begin.equals(resultMsg.begin) : resultMsg.begin != null) return false;
        if (end != null ? !end.equals(resultMsg.end) : resultMsg.end != null) return false;
        return logRateList != null ? logRateList.equals(resultMsg.logRateList) : resultMsg.logRateList == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = stockVO != null ? stockVO.hashCode() : 0;
        result = 31 * result + (begin != null ? begin.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        temp = Double.doubleToLongBits(lowest);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(highest);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(increase);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (logRateList != null ? logRateList.hashCode() : 0);
        temp = Double.doubleToLongBits(logVariance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "StockResultMsg{" +
                "stockVO=" + stockVO +
                ", begin=" + begin +
                ", end=" + end +
                ", lowest=" + lowest +
                ", highest=" + highest +
                ", increase=" + increase +
                ", logRateList=" + logRateList +
                ", logVariance=" + logVariance +
                '}';
    }
}
