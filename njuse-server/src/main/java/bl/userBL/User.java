package bl.userBL;

import po.user.UserPO;
import vo.UserVO;


public class User {
    String account,name,password;

    public User(String account, String name, String password) {
        this.account = account;
        this.name = name;
        this.password = password;
    }

    public User(UserPO po){
        this.account = po.getAccount();
        this.name = po.getName();
        this.password = po.getPassword();
    }

    public User(UserVO vo){
        this.account = vo.getAccount();
        this.name = vo.getName();
        this.password = vo.getPassword();
    }

    public UserVO toVO(){
        return new UserVO(this.account,this.name,this.password);
    }

    public UserPO toPO(){
        return new UserPO(this.account,this.name,this.password);
    }


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
