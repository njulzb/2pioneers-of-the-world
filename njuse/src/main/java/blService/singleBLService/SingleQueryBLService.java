package blService.singleBLService;

import utility.keyForSearch.KeyForSearchStock;
import utility.resultMsg.SingleResultMsg;


public interface SingleQueryBLService {
    public SingleResultMsg querySingleByKey(KeyForSearchStock key);
}
