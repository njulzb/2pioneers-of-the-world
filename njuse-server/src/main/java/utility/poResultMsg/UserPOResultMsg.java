package utility.poResultMsg;

import po.user.UserPO;
import resultMsg.ResultMsg;


public class UserPOResultMsg extends ResultMsg {
    UserPO user ;

    public UserPOResultMsg(boolean flag, String errorMsg, UserPO user) {
        super(flag, errorMsg);
        this.user = user;
    }

    public UserPO getUser() {
        return user;
    }

    public void setUser(UserPO user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPOResultMsg that = (UserPOResultMsg) o;

        return user != null ? user.equals(that.user) : that.user == null;
    }

    @Override
    public int hashCode() {
        return user != null ? user.hashCode() : 0;
    }
}
