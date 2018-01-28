package blService.marketBLService.stub;

import blService.marketBLService.MarketQueryBLService;
import utility.resultMsg.MarketResultMsg;
import vo.MarketVO;

import java.util.Date;

public class MarketQueryBLServiceStub implements MarketQueryBLService {

    @Override
    public MarketResultMsg queryMarketByDate(Date date) {
        MarketVO marketvo = new MarketVO(new Date(),
                100,
                10,20,
                30,40,
                50,60);

        MarketResultMsg resultMsg = new MarketResultMsg(true,"",marketvo);
        return resultMsg;
    }
}
