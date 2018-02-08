package UI.uiHelper;

import java.io.*;

public class LoginRemember {
    private static String recordPath = "C:/lastLogin.txt";

    public static void main(String args[]) {
        System.out.print("end");
    }

    public static void remeberThisTime(String userName, String password) {
        try {
            FileWriter fw = new FileWriter(recordPath);
            fw.write(userName + " " + password);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] getLast() {
        File file = new File(recordPath);
        String[] out = new String[2];
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null) {
                out = str.split(" ");
            }
            br.close();
        } catch (IOException e) {
            out[0] = "";
            out[1] = "";
        }

        return out;
    }


}
