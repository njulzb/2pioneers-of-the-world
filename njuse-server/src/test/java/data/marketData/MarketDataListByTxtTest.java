package data.marketData;

import org.junit.jupiter.api.Test;
import utility.DateHelper;
import vo.StockItem;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MarketDataListByTxtTest {
    @Test
    void getStockCodeOnday() {
        Date date = DateHelper.stringToDate("4/9/10");
        MarketDataListByTxt marketDataListByTxt = MarketDataListByTxt.getInstance();
        ArrayList<StockItem> itemArrayList = marketDataListByTxt.getItemsAtDay(date);
        assert(itemArrayList!=null && itemArrayList.size()!=0);
        itemArrayList.forEach((x)->System.out.println(x));

    }

}