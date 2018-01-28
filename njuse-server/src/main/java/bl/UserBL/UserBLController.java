package bl.UserBL;

import blService.UserBLService.NormalUserBLService;
import utility.resultMsg.UserResultMsg;

public class UserBLController implements NormalUserBLService {

    UserList userList = new UserList();

    @Override
    public UserResultMsg login(String account, String password) {
        return this.userList.login(account,password);
    }
}
