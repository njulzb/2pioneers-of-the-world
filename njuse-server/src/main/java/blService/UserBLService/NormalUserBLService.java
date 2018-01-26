package blService.UserBLService;

import utility.resultMsg.voResultMsg.UserResultMsg;

public interface NormalUserBLService {
    public UserResultMsg login(String username, String password);
}
