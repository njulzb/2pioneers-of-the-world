package utility.resultMsg;

import vo.StockVO;

public class StockResultMsg extends ResultMsg {

    StockVO stock ;//the stock result

    public StockResultMsg(boolean flag, String errorMsg,StockVO stock) {
        super(flag, errorMsg);
        this.stock = stock;
    }
    //getter and setter below

    public StockVO getStock() {
        return stock;
    }

    public void setStock(StockVO stock) {
        this.stock = stock;
    }

    //getter and setter above

}
