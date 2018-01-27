package utility.resultMsg.voResultMsg;

import utility.resultMsg.ResultMsg;
import vo.StockVO;

import java.util.ArrayList;

public class StockResultMsg extends ResultMsg {

    ArrayList<StockVO> stockVOArrayList ;

    public StockResultMsg(boolean flag, String errorMsg, ArrayList<StockVO> stockVOArrayList) {
        super(flag, errorMsg);
        this.stockVOArrayList = stockVOArrayList;
    }

    //getter and setter below

    public ArrayList<StockVO> getStockVOArrayList() {
        return stockVOArrayList;
    }

    public void setStockVOArrayList(ArrayList<StockVO> stockVOArrayList) {
        this.stockVOArrayList = stockVOArrayList;
    }


    //getter and setter above

}
