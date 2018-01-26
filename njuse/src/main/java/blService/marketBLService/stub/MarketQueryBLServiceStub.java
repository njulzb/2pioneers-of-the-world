package blService.marketBLService.stub;

import blService.marketBLService.MarketQueryBLService;
import utility.resultMsg.MarketResultMsg;

import java.util.Date;

public class MarketQueryBLServiceStub implements MarketQueryBLService {

    @Override
    public MarketResultMsg queryMarketByDate(Date date) {
        return null;
    }
}
