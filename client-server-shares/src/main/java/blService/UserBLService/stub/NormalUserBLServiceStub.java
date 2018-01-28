package blService.UserBLService.stub;

import blService.UserBLService.NormalUserBLService;
import utility.resultMsg.UserResultMsg;
import vo.UserVO;

public class NormalUserBLServiceStub implements NormalUserBLService {
    @Override
    public UserResultMsg login(String account, String password) {
        UserVO user = new UserVO("stub account","stub username","stub password");
        UserResultMsg resultMsg = new UserResultMsg(true,"no error",user);
        return resultMsg;
    }
}
