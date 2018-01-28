package utility.poResultMsg;

import po.stock.StockPO;
import resultMsg.ResultMsg;

public class StockPOResultMsg extends ResultMsg {
    StockPO stockPO;

    public StockPOResultMsg(boolean flag, String errorMsg, StockPO stockPO) {
        super(flag, errorMsg);
        this.stockPO = stockPO;
    }

    public StockPO getStockPO() {
        return stockPO;
    }

    public void setStockPO(StockPO stockPO) {
        this.stockPO = stockPO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockPOResultMsg that = (StockPOResultMsg) o;

        return stockPO != null ? stockPO.equals(that.stockPO) : that.stockPO == null;
    }

    @Override
    public int hashCode() {
        return stockPO != null ? stockPO.hashCode() : 0;
    }
}
