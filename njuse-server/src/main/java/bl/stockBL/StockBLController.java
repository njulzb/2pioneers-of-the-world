package bl.stockBL;

import blService.stockBLService.StockQueryBLService;
import data.stockData.StockDataListByTxt;
import keyForSearch.KeyForSearchStock;
import resultMsg.StockResultMsg;
import utility.poResultMsg.StockPOResultMsg;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;


public class StockBLController implements StockQueryBLService {

    private StockList stockList = new StockList();

    private Date getYesterday(Date today){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DATE,-1);
        today = calendar.getTime();
        return today;
    }

    private Date getTomorrow(Date today){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DATE,1);
        today = calendar.getTime();
        return today;
    }

    @Override
    public StockResultMsg queryStockByKey(KeyForSearchStock key)throws RemoteException {
       return this.stockList.queryStockByKey(key);
    }

    @Override
    public StockResultMsg queryStockByCodeAndDate(String code, Date begin, Date end) throws RemoteException{
        begin = this.getYesterday(begin);
        end = this.getTomorrow(end);
        return this.stockList.queryStockByCodeAndDate(code,begin,end);
    }

    @Override
    public StockResultMsg queryStockByNameAndDate(String name, Date begin, Date end) throws RemoteException {
        begin = this.getYesterday(begin);
        end = this.getTomorrow(end);
        return this.stockList.queryStockByNameAndDate(name,begin,end);
    }
}
