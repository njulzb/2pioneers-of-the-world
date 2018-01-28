package utility.resultMsg;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserResultMsg resultMsg = (UserResultMsg) o;

        return user != null ? user.equals(resultMsg.user) : resultMsg.user == null;
    }


}
