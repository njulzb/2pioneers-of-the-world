package bl.UserBL;

import blService.UserBLService.NormalUserBLService;
import utility.resultMsg.voResultMsg.UserResultMsg;

public class UserBLController implements NormalUserBLService {

    UserList userList = new UserList();

    @Override
    public UserResultMsg login(String username, String password) {
        return this.userList.login(username,password);
    }
}
