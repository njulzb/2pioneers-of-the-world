package data.marketData;


import dataService.marketDataService.MarketDataService;

import po.stock.StockPO;
import utility.DateHelper;
import utility.poResultMsg.MarketPOResultMsg;

import vo.StockItem;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class MarketDAO implements MarketDataService {

    private MarketDataListByTxt marketList = MarketDataListByTxt.getInstance();

    @Override
    public MarketPOResultMsg getStocksIn2Days(Date today) {
        Date yesterday = DateHelper.getYesterday(today);
        ArrayList<StockItem> todayList = this.marketList.getItemsAtDay(today),
                yesterdayList = this.marketList.getItemsAtDay(yesterday);

        if (todayList==null || yesterdayList==null ||
                todayList.size()==0 || yesterdayList.size()==0 ){

            return new MarketPOResultMsg(false,"search items failed",null);
        }

        //sort
        todayList.sort(Comparator.comparing(StockItem::getCode));
        yesterdayList.sort(Comparator.comparing(StockItem::getCode));

        ArrayList<StockPO> stockPOArrayList = new ArrayList<>();
        for (StockItem eItem : todayList) {


            String code = eItem.getCode(),
                    name = eItem.getName(),
                    market = eItem.getMarket();

            StockItem yesterdayItem = this.searchItemByCode(yesterdayList,code);
            if (yesterdayItem==null){
                continue;
            }


            //添加到item list 中，并保持顺序
            ArrayList<StockItem> poItemList = new ArrayList<>();
            poItemList.add(yesterdayItem);
            poItemList.add(eItem);


            StockPO stockPO = new StockPO(code,name,market,poItemList);
            stockPOArrayList.add(stockPO);




        }//遍历结束

        return new MarketPOResultMsg(true,"successful",stockPOArrayList);

    }

    private StockItem searchItemByCode(ArrayList<StockItem> list,String code){
        for (StockItem eItem : list) {
            if (eItem.getCode().equals(code)){
                return eItem;
            }
        }
        return null;
    }

}
