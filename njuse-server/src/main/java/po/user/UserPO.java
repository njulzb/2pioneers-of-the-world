package po.user;

import java.io.Serializable;

public class UserPO implements Serializable{
    String account,name,password;

    public UserPO(String account, String name, String password) {
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

        UserPO userPO = (UserPO) o;

        if (account != null ? !account.equals(userPO.account) : userPO.account != null) return false;
        if (name != null ? !name.equals(userPO.name) : userPO.name != null) return false;
        return password != null ? password.equals(userPO.password) : userPO.password == null;
    }


}
