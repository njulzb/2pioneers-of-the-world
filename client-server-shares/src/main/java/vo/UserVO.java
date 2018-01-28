package vo;


import java.io.Serializable;

public class UserVO implements Serializable{
    String account , name, password;

    public UserVO(String account, String name, String password) {
        this.account = account;
        this.name = name;
        this.password = password;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserVO userVO = (UserVO) o;

        if (account != null ? !account.equals(userVO.account) : userVO.account != null) return false;
        if (name != null ? !name.equals(userVO.name) : userVO.name != null) return false;
        return password != null ? password.equals(userVO.password) : userVO.password == null;
    }


}
