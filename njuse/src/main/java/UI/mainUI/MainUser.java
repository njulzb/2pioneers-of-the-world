package UI.mainUI;

public class MainUser {
    private static MainUser me = new MainUser();


    private String name = "default";

    private MainUser() {

    }

    public static MainUser getInstance() {
        return me;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


}
