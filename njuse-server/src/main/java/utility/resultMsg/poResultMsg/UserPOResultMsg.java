package utility.resultMsg.poResultMsg;

import po.user.UserPO;
import utility.resultMsg.ResultMsg;

public class UserPOResultMsg extends ResultMsg {
    UserPO userpo ;

    public UserPOResultMsg(boolean flag, String errorMsg, UserPO userpo) {
        super(flag, errorMsg);
        this.userpo = userpo;
    }

    public UserPO getUserpo() {
        return userpo;
    }

    public void setUserpo(UserPO userpo) {
        this.userpo = userpo;
    }
}
