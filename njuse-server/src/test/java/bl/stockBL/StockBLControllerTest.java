package bl.stockBL;

import org.junit.jupiter.api.Test;
import resultMsg.StockResultMsg;
import vo.StockItem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class StockBLControllerTest {
    @Test
    void queryStockByKey() {
    }

    @Test
    void queryStockByCodeAndDate() throws ParseException {
        StockBLController controller = new StockBLController();
        String code = "2";
        DateFormat format = new SimpleDateFormat("MM/dd/yy");
        Date begin = format.parse("4/1/14"),end = format.parse("5/1/14");
        StockResultMsg resultMsg = controller.queryStockByCodeAndDate(code,begin,end);
        assert(resultMsg!=null);
        assert(resultMsg.isSuccessful());
        for (StockItem eItem : resultMsg.getStockVOArrayList().get(0).getStockItemArrayList()){
            System.out.println(eItem);
        }

    }

}