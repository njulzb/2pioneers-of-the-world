package bl.userBL;

import blService.UserBLService.NormalUserBLService;
import resultMsg.UserResultMsg;


public class UserBLController implements NormalUserBLService {

    UserList userList = new UserList();

    @Override
    public UserResultMsg login(String account, String password) {
        return this.userList.login(account,password);
    }
}
