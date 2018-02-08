package bl.userBL;

import data.userData.UserDAO;
import dataService.userDataService.UserDataService;
import po.user.UserPO;
import resultMsg.UserResultMsg;
import utility.poResultMsg.UserPOResultMsg;


public class UserList {
    UserDataService userDataService = UserDAO.getInstance();
    public UserResultMsg login(String account, String password){
        UserPOResultMsg userPOResultMsg = this.userDataService.searchUserByAccount(account);
        UserPO userPO = userPOResultMsg.getUser();

        //对应账户名不存在
        if (userPOResultMsg.isSuccessful()==false || userPO.getAccount().equals(account)==false){
            return new UserResultMsg(false,"there is no user with that account",null);
        }

        //账号密码正确
        if (userPO.getPassword().equals(password)){
            return new UserResultMsg(true,"success",new User(userPO).toVO());
        }


        //密码不正确
        return new UserResultMsg(false,"password or account error" , null);

    }

}
