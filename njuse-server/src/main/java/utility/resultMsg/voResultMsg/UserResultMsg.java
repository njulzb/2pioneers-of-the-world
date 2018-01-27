package utility.resultMsg.voResultMsg;

import utility.resultMsg.ResultMsg;
import vo.UserVO;

public class UserResultMsg extends ResultMsg {
    private UserVO user;

    public UserResultMsg(boolean flag, String errorMsg,UserVO user) {
        super(flag, errorMsg);
        this.user = user;
    }

    //getter and setter below

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    //getter and setter above
}
