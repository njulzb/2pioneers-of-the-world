package data.userData;

import po.user.UserPO;
import utility.poResultMsg.UserPOResultMsg;

import java.io.*;
import java.util.ArrayList;

public class UserDataListByTxt {
    private static UserDataListByTxt instance = new UserDataListByTxt();
    public static UserDataListByTxt getInstance(){
        return instance;
    }
    ArrayList<String> userInfoList = new ArrayList<String>();
    private UserDataListByTxt(){

        String filePath = this.getClass().getClassLoader().getResource("user.txt").getPath();
        File file = new File(filePath);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                this.userInfoList.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public UserPOResultMsg searchUserByAccount(String account) {

        for (String e:this.userInfoList){
            String[] array = e.split("\t");
            if (array[0].equals(account)){
                UserPO userPO = new UserPO(array[0],array[1],array[2]);

                UserPOResultMsg resultMsg = new UserPOResultMsg(true,"successful",userPO);
                return resultMsg;
            }
        }
        return new UserPOResultMsg(false,"there is no user with the account",null);
    }



}
