package blService.UserBLService;

import utility.resultMsg.UserResultMsg;

public interface NormalUserBLService {
    public UserResultMsg login(String username , String password);
}
