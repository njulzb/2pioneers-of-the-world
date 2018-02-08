package bl.marketBL;

import blService.marketBLService.MarketQueryBLService;
import resultMsg.MarketResultMsg;

import java.util.Date;

public class MarketBLController implements MarketQueryBLService {

    private MarketList marketList = new MarketList();

    @Override
    public MarketResultMsg queryMarketByDate(Date date) {
        return this.marketList.queryMarketByDate(date);
    }
}
