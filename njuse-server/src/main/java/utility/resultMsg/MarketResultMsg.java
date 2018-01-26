package utility.resultMsg;

import vo.MarketVO;

public class MarketResultMsg extends ResultMsg {
    MarketVO market ;
    public MarketResultMsg(boolean flag, String errorMsg, MarketVO market) {
        super(flag, errorMsg);
        this.market = market;
    }
    //getter and setter below

    public MarketVO getMarket() {
        return market;
    }

    public void setMarket(MarketVO market) {
        this.market = market;
    }

    //getter and setter above
}