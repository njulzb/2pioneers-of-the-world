package data.marketData;

import org.junit.jupiter.api.Test;
import utility.DateHelper;
import utility.poResultMsg.MarketPOResultMsg;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MarketDAOTest {
    @Test
    void getStocksIn2Days1() {
    }

    @Test
    void getStocksIn2Days() {
        Date date = DateHelper.stringToDate("4/9/10");
        MarketDAO marketDAO = new MarketDAO();
        MarketPOResultMsg poResultMsg = marketDAO.getStocksIn2Days(date);
        assert(poResultMsg!=null  );
        assert(poResultMsg.isSuccessful());
        poResultMsg.getStockPOArrayList().forEach(x->System.out.println(x));
    }

}