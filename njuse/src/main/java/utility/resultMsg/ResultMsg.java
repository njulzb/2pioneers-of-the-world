package utility.resultMsg;

public class ResultMsg {
    private boolean flag;//indicate the methods result
    private String errorMsg;//

    public ResultMsg(boolean flag, String errorMsg) {
        this.flag = flag;
        this.errorMsg = errorMsg;
    }

    // getter and setter below
    public boolean isFlag() {
        return flag;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    //getter and setter above
}
