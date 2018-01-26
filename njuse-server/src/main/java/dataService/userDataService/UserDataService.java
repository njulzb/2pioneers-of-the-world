package dataService.userDataService;

import po.user.UserPO;
import utility.resultMsg.poResultMsg.UserPOResultMsg;

public interface UserDataService {


    public UserPOResultMsg searchUserByAccount(String account);
}
