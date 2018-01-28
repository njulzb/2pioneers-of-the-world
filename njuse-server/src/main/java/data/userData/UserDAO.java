package data.userData;


import dataService.userDataService.UserDataService;
import po.user.UserPO;
import utility.poResultMsg.UserPOResultMsg;


import java.io.*;
import java.util.ArrayList;

public class UserDAO implements UserDataService {

    private static UserDAO instance = new UserDAO();

    public static UserDAO getInstance() {
        return instance;
    }

    private UserDataListByTxt userDataListByTxt = UserDataListByTxt.getInstance();


    private UserDAO() {
    }


    @Override
    public UserPOResultMsg searchUserByAccount(String account) {
        return this.userDataListByTxt.searchUserByAccount(account);
    }
}
