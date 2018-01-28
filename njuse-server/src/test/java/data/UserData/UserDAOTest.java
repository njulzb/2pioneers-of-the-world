package data.UserData;

import dataService.userDataService.UserDataService;
import po.user.UserPO;
import utility.poResultMsg.UserPOResultMsg;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UserDAOTest {
    @org.junit.jupiter.api.Test
    void searchUserByAccount() {
        UserDataService userDataService = UserDAO.getInstance();

        String account = "161250063" ,name = "lzb" ,password = "161250063";
        UserPOResultMsg poResultMsg = userDataService.searchUserByAccount(account);
        UserPOResultMsg answer = new UserPOResultMsg(true,"successful",new UserPO(account,name,password));

        assertEquals(answer,poResultMsg);
    }

}