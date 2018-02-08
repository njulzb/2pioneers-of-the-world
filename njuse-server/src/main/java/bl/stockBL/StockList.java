package bl.stockBL;

import data.stockData.StockDAO;
import keyForSearch.KeyForSearchStock;
import resultMsg.StockResultMsg;
import utility.poResultMsg.StockPOResultMsg;
import vo.StockVO;

import java.util.ArrayList;
import java.util.Date;


public class StockList {

    private StockDAO stockDAO = new StockDAO();

    public StockResultMsg queryStockByKey(KeyForSearchStock key){
        //TODO
       return null;
    }

    public StockResultMsg queryStockByCodeAndDate(String code, Date begin, Date end){
        StockPOResultMsg poResultMsg = this.stockDAO.searchStockByCodeAndDate(code,begin,end);

        if (poResultMsg.isSuccessful()==false){
            return new StockResultMsg(false,"search failed",null);
        }

        StockVO stockVO = new Stock(poResultMsg.getStockPO()).toVO();
        return new StockResultMsg(true,"successful",stockVO);

    }


    public StockResultMsg queryStockByNameAndDate(String name,Date begin ,Date end){
        StockPOResultMsg poResultMsg = this.stockDAO.searchStockByNameAndDate(name,begin,end);

        if (poResultMsg.isSuccessful()==false){
            return new StockResultMsg(false,"search failed",null);
        }


        StockVO stockVO = new Stock(poResultMsg.getStockPO()).toVO();
        return new StockResultMsg(true,"successful",stockVO);

    }
}
