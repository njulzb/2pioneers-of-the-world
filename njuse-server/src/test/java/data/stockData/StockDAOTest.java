package data.stockData;

import org.junit.jupiter.api.Test;
import po.stock.StockPO;
import utility.DateHelper;
import utility.poResultMsg.StockPOResultMsg;
import vo.StockItem;

import java.util.Comparator;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class StockDAOTest {


    @Test
    void searchStockByCode() {
    }

    @Test
    void searchStockByName() {
    }

    @Test
    void searchStockByMarket() {
    }

    @Test
    void searchStockByCodeAndDate() {
        String code = "1";
        Date today = DateHelper.stringToDate("4/9/10");
        Date yesterday = DateHelper.getYesterday(today);
        StockDAO stockDAO = new StockDAO();
        StockPOResultMsg poResultMsg = stockDAO.searchStockByCodeAndDate(code,yesterday,today);
        assert (poResultMsg!=null && poResultMsg.isSuccessful());
        StockPO stockPO = poResultMsg.getStockPO();
        assert (stockPO!=null);
        stockPO.getStockItemArrayList().sort(Comparator.comparing(StockItem::getDate));
        System.out.println(stockPO.getStockItemArrayList());
    }

}