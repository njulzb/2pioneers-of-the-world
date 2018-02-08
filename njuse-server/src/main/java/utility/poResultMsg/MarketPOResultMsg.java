package utility.poResultMsg;

import po.stock.StockPO;
import resultMsg.ResultMsg;
import vo.StockVO;

import java.util.ArrayList;

/**
 * 要求所得的stockvolist 有两条item ，分别是昨天和今天的交易记录
 */
public class MarketPOResultMsg extends ResultMsg {
    private ArrayList<StockPO> stockPOArrayList;

    public MarketPOResultMsg(boolean flag, String errorMsg, ArrayList<StockPO> stockPOArrayList) {
        super(flag, errorMsg);
        this.stockPOArrayList = stockPOArrayList;
    }

    public ArrayList<StockPO> getStockPOArrayList() {
        return stockPOArrayList;
    }

    public void setStockPOArrayList(ArrayList<StockPO> stockPOArrayList) {
        this.stockPOArrayList = stockPOArrayList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarketPOResultMsg that = (MarketPOResultMsg) o;

        return stockPOArrayList != null ? stockPOArrayList.equals(that.stockPOArrayList) : that.stockPOArrayList == null;
    }

    @Override
    public int hashCode() {
        return stockPOArrayList != null ? stockPOArrayList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MarketPOResultMsg{" +
                "stockPOArrayList=" + stockPOArrayList +
                '}';
    }
}
