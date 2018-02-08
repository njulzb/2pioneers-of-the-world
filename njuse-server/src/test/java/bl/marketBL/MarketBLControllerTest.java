package bl.marketBL;

import org.junit.jupiter.api.Test;
import resultMsg.MarketResultMsg;
import utility.DateHelper;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MarketBLControllerTest {
    @Test
    void queryMarketByDate() {
        Date date = DateHelper.stringToDate("4/9/10");
        MarketBLController controller = new MarketBLController();
        MarketResultMsg resultMsg = controller.queryMarketByDate(date);
        assert(resultMsg!=null);
        assert(resultMsg.isSuccessful());
        System.out.println(resultMsg.getMarket());
    }

}