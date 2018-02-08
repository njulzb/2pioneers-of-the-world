package bl.marketBL;

import data.marketData.MarketDAO;
import dataService.marketDataService.MarketDataService;
import po.stock.StockPO;
import resultMsg.MarketResultMsg;
import utility.poResultMsg.MarketPOResultMsg;
import vo.MarketVO;
import vo.StockItem;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class MarketList {

    private MarketDataService marketDAO = new MarketDAO();


    public MarketResultMsg queryMarketByDate(Date date){
        MarketPOResultMsg poResultMsg = this.marketDAO.getStocksIn2Days(date);
        if (poResultMsg.isSuccessful()==false){
            return new MarketResultMsg(false, poResultMsg.getErrorMsg(),null);
        }

        ArrayList<StockPO> stockPOArrayList = poResultMsg.getStockPOArrayList();
        long volume=0 ;// 交易量
        long numOfLimitUp=0,numOfLimitDown=0;//涨停，跌停 股票数
        long numOfUpOver5=0 ,numOfDownOver5=0;//涨幅超过5%，跌幅超过5%的股票数
        long numOfUpOverYesterday5=0 ,numOfDownBelowYesterday5=0;//开盘‐收盘大于 5%*上一个交易日收盘价的 股票个数

        for (StockPO ePO : stockPOArrayList) {
            if (ePO.getStockItemArrayList().size()<2){
                return new MarketResultMsg(false, "the size of item list < 2",null);
            }
            ePO.getStockItemArrayList().sort(Comparator.comparing(StockItem::getDate));
            StockItem yesterday = ePO.getStockItemArrayList().get(0),
                    today = ePO.getStockItemArrayList().get(1);

            //volume
            volume += today.getVolume();
            //涨停
            if ( (today.getClose() - today.getOpen()) / yesterday.getClose() >= 0.1){
                numOfLimitUp ++;
            }
            //跌停
            if ((today.getClose() - today.getOpen()) / yesterday.getClose() <= -0.1){
                numOfLimitDown ++;
            }
            //涨幅超过5%
            if ( (today.getClose() - today.getOpen()) / yesterday.getClose() >= 0.05 ){
                numOfUpOver5 ++;
            }
            //跌幅超过5%
            if ( (today.getClose() - today.getOpen()) / yesterday.getClose() <=0.05 ){
                numOfDownOver5 ++;
            }
            //开盘‐收盘大于 5%*上一个交易日收盘价的 股票个数
            if ( (today.getOpen() - today.getClose())  >= ( yesterday.getClose() * 0.05) ){
                numOfUpOverYesterday5 ++;
            }
            //开盘‐收盘小于‐5%*上一个交易日收盘价的股票个数
            if ( (today.getOpen() - today.getClose())  <= ( yesterday.getClose() * 0.05)  ){
                numOfDownBelowYesterday5 ++;
            }

        }//遍历结束

        MarketVO marketVO = new MarketVO(date,volume,numOfLimitUp,numOfLimitDown,
                numOfUpOver5,numOfDownOver5, numOfUpOverYesterday5,numOfDownBelowYesterday5);
        return new MarketResultMsg(true,"successful",marketVO);

    }
}
