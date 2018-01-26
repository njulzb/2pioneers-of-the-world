package bl.UserBL;

import data.UserData.UserDAO;
import dataService.userDataService.UserDataService;
import utility.resultMsg.voResultMsg.UserResultMsg;

public class UserList {

    UserDataService userDataManager = new UserDAO();

    public UserResultMsg login(String username,String password){

        return null;
    }
}
