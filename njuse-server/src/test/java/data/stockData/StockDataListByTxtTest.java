package data.stockData;

import org.junit.jupiter.api.Test;
import po.stock.StockPO;
import utility.poResultMsg.StockPOResultMsg;
import vo.StockItem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Predicate;

class StockDataListByTxtTest {
    @Test
    void searchStockByNameAndDate() throws ParseException {
        StockDataListByTxt stockDataListByTxt = StockDataListByTxt.getInstance();
        DateFormat format = new SimpleDateFormat("MM/dd/yy");
        Date begin = format.parse("4/1/14"),end = format.parse("5/1/14");
        String name = "深发展Ａ";//"深发展Ａ";
        StockPOResultMsg poResultMsg = stockDataListByTxt.searchStockByNameAndDate(name,begin,end);
        assert(poResultMsg!=null);
        assert(poResultMsg.isSuccessful());
        assert(poResultMsg.getStockPO()!=null);
        for (StockItem eItem : poResultMsg.getStockPO().getStockItemArrayList()){
            System.out.println(eItem);
        }

    }

    @Test
    void searchStockByPredicate() {
        Predicate<String> byCode = x->{
            String[] array = x.split("\t");
            String code = array[8];
            return code.equals("1");
        };
        StockDataListByTxt stockDataListByTxt = StockDataListByTxt.getInstance();
        StockPOResultMsg resultMsg = stockDataListByTxt.searchStockByPredicate(byCode);
        assert(resultMsg!=null);
        assert(resultMsg.isSuccessful());
        assert(resultMsg.getStockPO()!=null);
        for (StockItem eItem : resultMsg.getStockPO().getStockItemArrayList()){
            System.out.println(eItem);
        }


    }

    @Test
    void searchStockByCodeAndDate() throws ParseException {
        StockDataListByTxt stockDataListByTxt = StockDataListByTxt.getInstance();
        DateFormat format = new SimpleDateFormat("MM/dd/yy");
        Date begin = format.parse("4/1/14"),end = format.parse("5/1/14");
        String code = "1";
        StockPOResultMsg poResultMsg = stockDataListByTxt.searchStockByCodeAndDate(code,begin,end);
        assert(poResultMsg!=null);
        assert(poResultMsg.isSuccessful());
        assert(poResultMsg.getStockPO()!=null);
        for (StockItem eItem : poResultMsg.getStockPO().getStockItemArrayList()){
            System.out.println(eItem);
        }
    }

    @Test
    void searchStockByMarket() {
        StockDataListByTxt stockDataListByTxt = StockDataListByTxt.getInstance();
        String market = "SZ";
        StockPOResultMsg resultMsg = stockDataListByTxt.searchStockByMarket(market);
        assert(resultMsg.isSuccessful());
        assert(resultMsg.getStockPO()!=null);
        StockPO stockPO = resultMsg.getStockPO();
        System.out.printf("code:%s\tname:%s\tmarket:%s\n",stockPO.getCode(),stockPO.getName(),stockPO.getMarket());
        for (StockItem eItem : stockPO.getStockItemArrayList()){
            System.out.println(eItem);
        }

    }

    @Test
    void searchStockByName() {
        StockDataListByTxt stockDataListByTxt = StockDataListByTxt.getInstance();
        String name = "华兰生物";
        StockPOResultMsg resultMsg = stockDataListByTxt.searchStockByName(name);
        assert(resultMsg.isSuccessful());
        assert(resultMsg.getStockPO()!=null);
        StockPO stockPO = resultMsg.getStockPO();
        System.out.printf("code:%s\tname:%s\tmarket:%s\n",stockPO.getCode(),stockPO.getName(),stockPO.getMarket());
        for (StockItem eItem : stockPO.getStockItemArrayList()){
            System.out.println(eItem);
        }

    }

    @Test
    void searchStockByCode() {
        StockDataListByTxt stockDataListByTxt = StockDataListByTxt.getInstance();
        String code = "1";
        StockPOResultMsg resultMsg = stockDataListByTxt.searchStockByCode(code);
        assert(resultMsg.isSuccessful());
        assert(resultMsg.getStockPO()!=null);
        StockPO stockPO = resultMsg.getStockPO();
        System.out.printf("code:%s\tname:%s\tmarket:%s\n",stockPO.getCode(),stockPO.getName(),stockPO.getMarket());
        for (StockItem eItem : stockPO.getStockItemArrayList()){
            System.out.println(eItem);
        }
    }

    @Test
    void searchStockByPredicate2() {
        Predicate<String> byCode = x->{
            String[] array = x.split("\t");
            String name = array[9];
            return name.equals("深发展Ａ");
        };
        StockDataListByTxt stockDataListByTxt = StockDataListByTxt.getInstance();
        StockPOResultMsg resultMsg = stockDataListByTxt.searchStockByPredicate(byCode);
        assert(resultMsg!=null);
        assert(resultMsg.isSuccessful());
        assert(resultMsg.getStockPO()!=null);
        for (StockItem eItem : resultMsg.getStockPO().getStockItemArrayList()){
            System.out.println(eItem);
        }
    }
}