package bl.stockBL;

import org.junit.jupiter.api.Test;
import resultMsg.StockResultMsg;
import vo.StockItem;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class StockBLControllerTest {


    @Test
    void queryStockByCodeAndDate1() throws ParseException, RemoteException {
        StockBLController controller = new StockBLController();
        String code = "98798798798798798";
        DateFormat format = new SimpleDateFormat("MM/dd/yy");
        Date begin = format.parse("4/1/10"),end = format.parse("5/1/14");
        StockResultMsg resultMsg = controller.queryStockByCodeAndDate(code,begin,end);
        assert(resultMsg!=null);
        assert (resultMsg.isSuccessful()==false);

    }


    @Test
    void queryStockByNameAndDate() throws ParseException, RemoteException {
        StockBLController controller = new StockBLController();
        String name = "江苏国泰";
        DateFormat format = new SimpleDateFormat("MM/dd/yy");
        Date begin = format.parse("4/1/14"),end = format.parse("4/3/14");
        StockResultMsg resultMsg = controller.queryStockByNameAndDate(name,begin,end);
        assert(resultMsg!=null);
        assert(resultMsg.isSuccessful());
        System.out.println(resultMsg);
        for (StockItem eItem : resultMsg.getStockVO().getStockItemArrayList()){
            System.out.println(eItem);
        }


    }



    @Test
    void queryStockByCodeAndDate() throws ParseException, RemoteException {
        StockBLController controller = new StockBLController();
        String code = "2";
        DateFormat format = new SimpleDateFormat("MM/dd/yy");
        Date begin = format.parse("4/1/14"),end = format.parse("5/1/14");
        StockResultMsg resultMsg = controller.queryStockByCodeAndDate(code,begin,end);
        assert(resultMsg!=null);
        assert(resultMsg.isSuccessful());
        for (StockItem eItem : resultMsg.getStockVO().getStockItemArrayList()){
            System.out.println(eItem);
        }

    }

}